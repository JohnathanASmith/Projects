import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:uncwnavigatorapplication/constants/app_icons.dart';
import 'package:uncwnavigatorapplication/drawer_navigator/profile_picture.dart';
import 'package:uncwnavigatorapplication/models/site_model.dart';
import 'package:uncwnavigatorapplication/models/user_model.dart';
import 'package:uncwnavigatorapplication/screens/aboutscreen.dart';
import 'package:uncwnavigatorapplication/screens/favoritesscreen.dart';
import 'package:uncwnavigatorapplication/screens/homescreen.dart';
import 'package:uncwnavigatorapplication/screens/loginscreen.dart';
class My_Drawer_Navigator extends StatefulWidget {
  const My_Drawer_Navigator({super.key});

  @override
  State<My_Drawer_Navigator> createState() => _My_Drawer_NavigatorState();
}

class _My_Drawer_NavigatorState extends State<My_Drawer_Navigator> {
  final siteRef = FirebaseFirestore.instance.collection('site');


  @override
  Widget build(BuildContext context) {
    return
    Drawer(
      child: ListView(
        padding: const EdgeInsets.all(0),
        children: [
          Profile_Picture_Widget(context),
          My_List_Tile.build(
              const HomeScreen(), AppIcons.home, "Home", context),
          My_List_Tile.build(
              const FavoritesScreen(), AppIcons.favorite, "Favorites", context),
          My_List_Tile.build(
              const AboutScreen(), AppIcons.about, "About", context),
          ListTile(
            leading: AppIcons.logout,
            title: Text("Logout"),
            onTap: () {
              // signOut() doesn't return anything, so we don't need to await
              // for it to finish unless we really want to.
              FirebaseAuth.instance.signOut();
              // This navigator call clears the Navigation stack and takes
              // them to the login screen because we don't want users
              // "going back" in our app after they log out.
              Navigator.of(context).pushAndRemoveUntil(
                  MaterialPageRoute(builder: (context) => const LoginScreen()),
                  (route) => false);
            },
          ),
          // Used to add sites of interest to tha database.
          // ListTile(
          //   title: Wrap(children: [ Text(
          //       'This will add sites to the database. It is a list of six predefined sites.')],),
          //   leading: Icon(Icons.abc),
          //   onTap: () {
          //     _generateAndAddSite();
          //   },
          // )
        ],
      ),
    );
  }

  void _generateAndAddSite() async {
    for (SiteOfInterest site in SitesData().sitesOfInterest) {
      try {
        // This call transmits the data to the Firestore.
        // the 'await' call blocks execution until something comes back from the network.
        // the DocumentReference is a pointer to the Document in the cloud that was created.
        DocumentReference doc = await siteRef.add(site.toMap());

        // Show a success message with the document ID.
        if (!mounted) return;
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Success! Added ${doc.id}')),
        );
      } on FirebaseException catch (e) {
        // Something went terribly wrong
        if (!mounted) return;
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Something went wrong! ${e.message}')),
        );
      }
    }
  }
}

class My_List_Tile {
  My_List_Tile._();

  static ListTile build(
      Widget destination, Icon icon, String title, BuildContext context) {
    return ListTile(
      leading: icon,
      title: Text(title),
      onTap: () {
        // Need to handle the logout function
        Navigator.of(context).pop();
        Navigator.of(context).push(MaterialPageRoute(
          builder: (context) => destination,
        ));
      },
    );
  }
  
}
