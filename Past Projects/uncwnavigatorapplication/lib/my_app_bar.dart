import 'package:flutter/material.dart';
import 'package:uncwnavigatorapplication/constants/app_colors.dart';

class My_App_Bar {
  const My_App_Bar._();

  static AppBar build(String title) {
    return AppBar(
      backgroundColor: AppColors.primary,
      title: Text(title),
    );
  }
}
