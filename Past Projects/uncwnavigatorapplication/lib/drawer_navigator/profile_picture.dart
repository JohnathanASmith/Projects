import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:uncwnavigatorapplication/constants/app_colors.dart';
import 'package:uncwnavigatorapplication/drawer_navigator/picture_handler.dart';
import 'package:uncwnavigatorapplication/models/user_model.dart';

class Profile_Picture_Widget extends StatefulWidget {
  const Profile_Picture_Widget(BuildContext context, {super.key});

  @override
  State<Profile_Picture_Widget> createState() => _Profile_Picture_WidgetState();
}

class _Profile_Picture_WidgetState extends State<Profile_Picture_Widget> {
  UserModel? user;

  Future<UserModel?> getUser() async {
    await FirebaseFirestore.instance.collection('users').get().then((value) {
      value.docs.forEach((element) {
        if (element.data()['uid'] == FirebaseAuth.instance.currentUser?.uid) {
          user = UserModel(
            uid: element.data()['uid'], 
            photoUrl: element.data()['photoUrl'],
            email: element.data()['email'],
            first: element.data()['first'],
            last: element.data()['last'],
            username: element.data()['username']);
        } 
      });
    });
    return user;
  
  }

  @override
  Widget build(BuildContext context) {
    return 
    FutureBuilder(
      future: getUser(),
      builder: (context, snapshot) => 
    UserAccountsDrawerHeader(
            decoration: BoxDecoration(color: AppColors.primary),
            currentAccountPicture: CircleAvatar(
              backgroundColor: AppColors.primaryAccent,
              radius: 50.0,
              child: Picture_Handler.build(user),
            ),
            accountName: Text('${user?.first}, ${user?.last}'),
            accountEmail: Text('${user?.email}')));
  }
}