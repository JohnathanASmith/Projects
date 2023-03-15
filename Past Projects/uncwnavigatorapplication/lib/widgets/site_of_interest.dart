import 'dart:ui';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_storage/firebase_storage.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:get/get.dart';
import 'package:uncwnavigatorapplication/constants/app_colors.dart';
import 'package:uncwnavigatorapplication/models/site_model.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../screens/sitedetailscreen.dart';
import 'package:flutter_cache_manager/flutter_cache_manager.dart';
import 'package:share_plus/share_plus.dart';
import 'package:cached_network_image/cached_network_image.dart';

class MyCardForDisplay extends StatefulWidget {
  MyCardForDisplay(this.site, {super.key});

  QueryDocumentSnapshot<Object?> site;

  @override
  State<MyCardForDisplay> createState() => _MyCardForDisplayState();
}

class _MyCardForDisplayState extends State<MyCardForDisplay> {
  String? imageURL;
  var storageRef = FirebaseStorage.instance.ref();
  var siteRef = FirebaseFirestore.instance.collection('site');
  var path;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getFileUrl();
  }

  void _getFileUrl() async {
    try {
      ListResult result = await storageRef.child('images').listAll();
    path = widget.site.get('siteImageReference');
    for (Reference ref in result.items) {
      if (ref.name.startsWith(path)) {
        imageURL = await ref.getDownloadURL();
        setState(() {});
      }
    }
      
    } catch (e) {
      print('getFileUrl issue');
    }
  }

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
        onDoubleTap: () {
          Navigator.of(context).push(MaterialPageRoute(
            builder: (context) =>
                DetailScreen(site: widget.site, imageURL: imageURL),
          ));
        },
        onTap: () {
          List<dynamic> favoritedBy = widget.site.get('favoritedBy');

          if (!favoritedBy.remove(FirebaseAuth.instance.currentUser!.uid)) {
            favoritedBy.add(FirebaseAuth.instance.currentUser!.uid);
            Get.snackbar('Double tap to see details about site!', '',
            forwardAnimationCurve: Curves.fastLinearToSlowEaseIn,
            isDismissible: true,
            borderColor: Colors.black,
            margin: EdgeInsets.all(10),
            borderWidth: 4,
            borderRadius: 30,
            animationDuration: Duration(milliseconds: 3000),
            snackPosition: SnackPosition.BOTTOM,
            duration: const Duration(seconds: 4),
            backgroundColor: AppColors.primaryAccent,
            );
          }
          // updates argument in dictionary we want to change
          siteRef.doc(widget.site.id).update({'favoritedBy': favoritedBy});
        },
        child: Card(
            color: Colors.white,
            child: Padding(
              padding: EdgeInsets.all(4),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  if (imageURL == null)
                    const CircularProgressIndicator(color: Colors.black),
                  if (imageURL != null)
                    Container(
                        color: AppColors.blackCard,
                        constraints: BoxConstraints(maxWidth: 75, minWidth: 75),
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
                  SizedBox(
                      child: FittedBox(
                    child: Text(
                      widget.site.get('siteName'),
                      style: TextStyle(
                          color: Colors.black,
                          fontSize: 25),
                    ),
                  )),
                  Expanded(
                      child: Row(
                          mainAxisAlignment: MainAxisAlignment.end,
                          children: [
                        (widget.site.get('favoritedBy').contains(
                                FirebaseAuth.instance.currentUser!.uid))
                            ? Icon(
                                Icons.star,
                                color: Colors.yellow,
                              )
                            : Icon(Icons.star_border),
                      ]))
                ],
              ),
            )));
  }
}
