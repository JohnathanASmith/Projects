import 'package:flutter/material.dart';
import 'package:uncwnavigatorapplication/drawer_navigator/my_drawer_navigator.dart';
import 'package:uncwnavigatorapplication/my_app_bar.dart';
import 'package:uncwnavigatorapplication/widgets/favorites_site_list.dart';
import 'package:uncwnavigatorapplication/widgets/site_list.dart';

import '../constants/app_colors.dart';

class FavoritesScreen extends StatefulWidget {
  const FavoritesScreen({super.key});

  @override
  State<FavoritesScreen> createState() => _AboutScreenState();
}

class _AboutScreenState extends State<FavoritesScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppColors.primary,
      appBar: My_App_Bar.build("Favorites Screen"),
      drawer: My_Drawer_Navigator(),
      body: Container(
              child: favoriteSiteList(),
            ),
    );
  }
}
