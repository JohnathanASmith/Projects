import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:uncwnavigatorapplication/constants/app_colors.dart';
import 'package:uncwnavigatorapplication/models/site_model.dart';
import 'package:uncwnavigatorapplication/widgets/site_of_interest.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class favoriteSiteList extends StatelessWidget {
  favoriteSiteList({super.key});

  final siteRef = FirebaseFirestore.instance.collection('site').where(
      'favoritedBy',
      arrayContains: '${FirebaseAuth.instance.currentUser!.uid}');

  @override
  Widget build(BuildContext context) {
    return StreamBuilder(
      stream: siteRef.snapshots(),
      builder: (context, snapshot) {
        if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
          return Scaffold(
            backgroundColor: AppColors.primary,
            body: 
            Text("You do not have any favorites.",
            
                textAlign: TextAlign.center,
                style: TextStyle(
                      color: Colors.white,
                      fontSize: 50,
                      fontWeight: FontWeight.bold),),
          );
        }

        // extra
        if (snapshot.hasError) {
          // if the network is unreachable, or if firestore throws an acess exception
        }

        var siteDocs = snapshot.data!.docs;

        return Scaffold(
          // floatingActionButton: FloatingActionButton(onPressed: () => print("object"),),
          backgroundColor: AppColors.primary,
          body: ListView.builder(
            addAutomaticKeepAlives: true,
            itemCount: siteDocs.length,
            itemBuilder: (context, index) {
              return MyCardForDisplay(siteDocs[index]);
            },)
          // GridView.builder(
          //   addAutomaticKeepAlives: true,
          //   itemCount: siteDocs.length,
          //   gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
          //       crossAxisCount: 1, childAspectRatio: 5),
          //   itemBuilder: (context, index) {
          //     // might change this to list tiles not cards
          //     return MyCardForDisplay(siteDocs[index]);
          //   },
          // ),
        );
      },
    );
  }
}
