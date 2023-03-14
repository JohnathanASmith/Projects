import 'package:uncwnavigatorapplication/constants/app_colors.dart';
import 'package:uncwnavigatorapplication/models/user_model.dart';
import 'package:flutter/material.dart';

class Picture_Handler {
  const Picture_Handler._();

  static Widget build(UserModel? user) {
    // Will be a if else that checks if user has a photo saved in the database
    // and uses that instead of their initials
    if (user?.photoUrl == '' || user?.photoUrl == null) {
      return Text(
      "${user?.first?[0]} ${user?.last?[0]}",
      style: TextStyle(
          fontWeight: FontWeight.bold,
          fontSize: 24,
          color: AppColors.whiteLetterColor),
    );
    } else {
      // should be if they actually have an image havent added
      return Text(
      "${user?.first?[0]} ${user?.last?[0]}",
      style: TextStyle(
          fontWeight: FontWeight.bold,
          fontSize: 24,
          color: AppColors.whiteLetterColor),
    );
    }
  }
}
