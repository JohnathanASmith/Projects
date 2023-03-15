import 'package:flutter/material.dart';
import 'package:geolocator/geolocator.dart';
import 'package:get/get.dart';
import 'package:location/location.dart';
import 'package:uncwnavigatorapplication/constants/app_colors.dart';

class LocationService {

  static Future<bool> askLocation() async {
    Location location = Location();

    bool serviceEnabled;
    PermissionStatus permissionGranted;

    serviceEnabled = await location.serviceEnabled();
    if (!serviceEnabled) {
      serviceEnabled = await location.requestService();
      if (!serviceEnabled) {
        Get.snackbar('Location Services: OFF\nTap To Go To Settings', '',
            dismissDirection: DismissDirection.horizontal,
            forwardAnimationCurve: Curves.fastLinearToSlowEaseIn,
            isDismissible: true,
            borderColor: Colors.black,
            margin: EdgeInsets.all(10),
            borderWidth: 4,
            borderRadius: 30,
            animationDuration: Duration(milliseconds: 3000),
            snackPosition: SnackPosition.BOTTOM,
            duration: const Duration(seconds: 8),
            backgroundColor: AppColors.primaryAccent,
            onTap: (snack) => Geolocator.openLocationSettings());
        return false;
      }
    }
    // 34.2261, -77.8718
    permissionGranted = await location.hasPermission();
    if (permissionGranted == PermissionStatus.denied) {
      permissionGranted = await location.requestPermission();
      if (permissionGranted != PermissionStatus.granted) {
        Get.snackbar('Location Services: OFF\nTap To Go To Settings', '',
            dismissDirection: DismissDirection.horizontal,
            borderColor: Colors.black,
            margin: EdgeInsets.all(10),
            borderWidth: 4,
            shouldIconPulse: true,
            animationDuration: Duration(milliseconds: 3000),
            snackPosition: SnackPosition.BOTTOM,
            duration: const Duration(seconds: 8),
            backgroundColor: AppColors.primaryAccent,
            onTap: (snack) => Geolocator.openLocationSettings());
        return false;
      }
    }
    return true;
  }
}
