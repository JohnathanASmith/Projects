import 'package:flutter/material.dart';
import 'package:uncwnavigatorapplication/constants/app_colors.dart';
import 'package:uncwnavigatorapplication/drawer_navigator/my_drawer_navigator.dart';
import 'package:uncwnavigatorapplication/my_app_bar.dart';

class AboutScreen extends StatefulWidget {
  const AboutScreen({super.key});

  @override
  State<AboutScreen> createState() => _AboutScreenState();
}

class _AboutScreenState extends State<AboutScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppColors.primary,
      appBar: My_App_Bar.build("About Screen"),
      drawer: My_Drawer_Navigator(),
      body: Center(
        child: Text("This app was created by Johnathan Smith"),
      ),
    );
  }
}
