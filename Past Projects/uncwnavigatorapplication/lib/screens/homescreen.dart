import 'package:flutter/material.dart';
import 'package:split_view/split_view.dart';
import 'package:uncwnavigatorapplication/constants/app_colors.dart';
import 'package:uncwnavigatorapplication/location_services.dart';
import 'package:uncwnavigatorapplication/models/site_model.dart';
import 'package:uncwnavigatorapplication/my_app_bar.dart';
import 'package:uncwnavigatorapplication/screens/map_screen.dart';
import 'package:uncwnavigatorapplication/widgets/site_list.dart';
import '../drawer_navigator/my_drawer_navigator.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
      future: LocationService.askLocation(),
      builder: (context, snapshot) =>
    
    Scaffold(
        appBar: My_App_Bar.build("UNCW Navigator"),
        drawer: const My_Drawer_Navigator(),
        body: Column(
          children: [
            Expanded(child: MapScreen()),
            Expanded(child: SiteList())
          ],
        )

        

        
        // SplitView(
        //   gripSize: 30,
        //   gripColor: AppColors.primary,
        //   gripColorActive: AppColors.primaryAccent,
        //   controller: SplitViewController(
        //       limits: [WeightLimit(min: 0.0), WeightLimit(min: 0.1)]),
        //   viewMode: SplitViewMode.Vertical,
        //   indicator: const SplitIndicator(
        //     viewMode: SplitViewMode.Vertical,
        //   ),
        //   activeIndicator: const SplitIndicator(
        //     viewMode: SplitViewMode.Vertical,
        //     isActive: true,
        //   ),
        //   children: [
        //     Container(
        //       child: MapScreen(),
        //     ),
        //     Container(
        //       child: SiteList(),
        //     ),
        //   ],
        // )
        ));
  }
}
