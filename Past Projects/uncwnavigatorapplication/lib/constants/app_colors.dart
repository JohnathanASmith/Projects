import 'package:flutter/animation.dart';
import 'package:flutter/material.dart';

class AppColors {
  const AppColors._();

  static MaterialColor get primary => Colors.teal;
  static Color get primaryAccent => Colors.teal.shade200;
  static Color? get secondary => Colors.teal[400];

  static Color get whiteLetterColor => Colors.white70;
  static Color get blackCard => Colors.black;
}
