import 'package:cached_network_image/cached_network_image.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:uncwnavigatorapplication/constants/app_colors.dart';

import 'package:uncwnavigatorapplication/my_app_bar.dart';

class DetailScreen extends StatelessWidget {
  const DetailScreen({super.key, this.site, this.imageURL});

  final imageURL;
  final site;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppColors.primary,
      appBar: My_App_Bar.build("Detail Screen"),
      body: SingleChildScrollView(
          padding: EdgeInsets.all(16),
          child: Container(
            alignment: Alignment.center,
            padding: EdgeInsetsDirectional.all(16),
            decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(30),
                border: Border.all(width: 3)),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                if (imageURL == null)
                  const CircularProgressIndicator(color: Colors.black),
                if (imageURL != null)
                  Container(
                      color: AppColors.blackCard,
                      child: DecoratedBox(
                        child: CachedNetworkImage(
                            placeholder: (context, url) => const CircularProgressIndicator(),
                            errorWidget: (context, url, error) => const Icon(Icons.error),
                            imageUrl: imageURL!),
                        position: DecorationPosition.foreground,
                        decoration: BoxDecoration(
                            border: Border.all(
                                color: AppColors.blackCard,
                                style: BorderStyle.solid,
                                width: 3)),
                      )),
                Text(
                  site.get('siteName'),
                  textAlign: TextAlign.center,
                  style: TextStyle(
                      color: Colors.black,
                      fontSize: 50,
                      fontWeight: FontWeight.bold),
                ),
                (site
                        .get('favoritedBy')
                        .contains(FirebaseAuth.instance.currentUser!.uid))
                    ? Icon(
                        Icons.star,
                        color: Colors.yellow,
                      )
                    : Icon(Icons.star_border),
                Text(
                  site.get('siteDescription'),
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 16),
                ElevatedButton(
                    style: ButtonStyle(
                        backgroundColor:
                            MaterialStateProperty.all(AppColors.primaryAccent)),
                    onPressed: () {
                      Navigator.pop(context);
                    },
                    child: Text("Go Back"))
              ],
            ),
          )),
    );
  }
}
