import 'package:flutter/material.dart';
import 'package:get/get_navigation/src/root/get_material_app.dart';
import 'package:uncwnavigatorapplication/screens/homescreen.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:uncwnavigatorapplication/screens/loginscreen.dart';
import 'firebase_options.dart';

 void main() async {
   runApp(const MyApp());
   await Firebase.initializeApp(
     options: DefaultFirebaseOptions.currentPlatform,
   );
 }

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: 'UNCW Navigator',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const LoginScreen(),
    );
  }
}
