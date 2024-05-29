import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_firebase/firebase_options.dart';

const List<String> list = <String>['', 'Low', 'Medium', 'High'];

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Task Manager',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final TextEditingController _libelleController = TextEditingController();
  final TextEditingController _dateController = TextEditingController();
  String _prioriteValue = list.first;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'Libelle de tache',
              style: TextStyle(
                fontSize: 18.0,
                fontWeight: FontWeight.bold,
              ),
            ),
            const SizedBox(height: 10.0),
            TextField(
              controller: _libelleController,
              decoration: const InputDecoration(
                hintText: 'Entrez le libelle de la tache',
              ),
            ),
            const SizedBox(height: 10.0),
            TextField(
              controller: _dateController,
              decoration: const InputDecoration(
                hintText: 'Entrez la date de la tache (jj/mm/aaaa)',
              ),
            ),
            const SizedBox(height: 10.0),
            DropdownButton<String>(
              value: _prioriteValue,
              onChanged: (String? newValue) {
                setState(() {
                  _prioriteValue = newValue!;
                });
              },
              items: list.map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
            ),
            const SizedBox(height: 20.0),
            ElevatedButton(
              onPressed: () {
                String libelle = _libelleController.text;
                String date = _dateController.text;
                if (libelle.isNotEmpty && date.isNotEmpty && _prioriteValue.isNotEmpty) {
                  ajouterTache(libelle, date, _prioriteValue);
                  _libelleController.clear();
                  _dateController.clear();
                  setState(() {
                    _prioriteValue = list.first;
                  });
                } else {
                  showDialog(
                    context: context,
                    builder: (context) {
                      return AlertDialog(
                        title: Text('Erreur'),
                        content: Text('Veuillez remplir tous les champs pour ajouter une tache.'),
                        actions: [
                          TextButton(
                            onPressed: () {
                              Navigator.pop(context);
                            },
                            child: Text('OK'),
                          ),
                        ],
                      );
                    },
                  );
                }
              },
              child: const Text('Ajouter une tache'),
            ),
            const SizedBox(height: 20.0),
            Expanded(
              child: StreamBuilder<QuerySnapshot>(
                stream: FirebaseFirestore.instance.collection('taches').snapshots(),
                builder: (context, snapshot) {
                  if (snapshot.connectionState == ConnectionState.waiting) {
                    return Center(child: CircularProgressIndicator());
                  } else if (snapshot.hasError) {
                    return Center(child: Text('Error: ${snapshot.error}'));
                  } else {
                    final data = snapshot.data!.docs;
                    return ListView.builder(
                      itemCount: data.length,
                      itemBuilder: (context, index) {
                        final tache = data[index].data() as Map<String, dynamic>;
                        bool isChecked = tache['checked'] ?? false;
                        return CheckboxListTile(
                          title: Text(
                            tache['libelle'],
                            style: isChecked ? TextStyle(decoration: TextDecoration.lineThrough) : null,
                          ),
                          subtitle: Text('Date: ${tache['date']}, Priorité: ${tache['priorite']}'),
                          value: isChecked,
                          onChanged: (bool? value) {
                            FirebaseFirestore.instance.collection('taches').doc(data[index].id).update({'checked': value});
                          },
                          secondary: IconButton(
                            icon: Icon(Icons.delete),
                            onPressed: () {
                              FirebaseFirestore.instance.collection('taches').doc(data[index].id).delete();
                            },
                          ),
                        );
                      },
                    );
                  }
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}

Future<void> ajouterTache(String libelle, String date, String priorite) {
  CollectionReference taches = FirebaseFirestore.instance.collection('taches');

  return taches.add({
    'libelle': libelle,
    'date': date,
    'priorite': priorite,
    'checked': false, // Ajouter une clé 'checked' initialisée à false
  });
}
