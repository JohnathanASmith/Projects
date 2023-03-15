// File generated by FlutterFire CLI.
// ignore_for_file: lines_longer_than_80_chars, avoid_classes_with_only_static_members
import 'package:firebase_core/firebase_core.dart' show FirebaseOptions;
import 'package:flutter/foundation.dart'
    show defaultTargetPlatform, kIsWeb, TargetPlatform;

/// Default [FirebaseOptions] for use with your Firebase apps.
///
/// Example:
/// ```dart
/// import 'firebase_options.dart';
/// // ...
/// await Firebase.initializeApp(
///   options: DefaultFirebaseOptions.currentPlatform,
/// );
/// ```
class DefaultFirebaseOptions {
  static FirebaseOptions get currentPlatform {
    if (kIsWeb) {
      return web;
    }
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return android;
      case TargetPlatform.iOS:
        return ios;
      case TargetPlatform.macOS:
        return macos;
      case TargetPlatform.windows:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for windows - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      case TargetPlatform.linux:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for linux - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      default:
        throw UnsupportedError(
          'DefaultFirebaseOptions are not supported for this platform.',
        );
    }
  }

  static const FirebaseOptions web = FirebaseOptions(
    apiKey: 'AIzaSyDK7sNw4J39tr96P89meZs9wpNyg9y87ZM',
    appId: '1:942643978105:web:14fabccc431756e58f19a8',
    messagingSenderId: '942643978105',
    projectId: 'uncwnavigator',
    authDomain: 'uncwnavigator.firebaseapp.com',
    storageBucket: 'uncwnavigator.appspot.com',
    measurementId: 'G-D7EGCX04CL',
  );

  static const FirebaseOptions android = FirebaseOptions(
    apiKey: 'AIzaSyAi6md6W_uT99c11oP2sRRJj2PUfM3udk8',
    appId: '1:942643978105:android:e2d0dac3528f8a498f19a8',
    messagingSenderId: '942643978105',
    projectId: 'uncwnavigator',
    storageBucket: 'uncwnavigator.appspot.com',
  );

  static const FirebaseOptions ios = FirebaseOptions(
    apiKey: 'AIzaSyAqYvoxR2BQOCnq3F6l0lK_jWMPIGtw9ds',
    appId: '1:942643978105:ios:2869be1d987d92c68f19a8',
    messagingSenderId: '942643978105',
    projectId: 'uncwnavigator',
    storageBucket: 'uncwnavigator.appspot.com',
    iosClientId: '942643978105-v6i1r6gq3u1bp11p07j9epn9uqlvh9bo.apps.googleusercontent.com',
    iosBundleId: 'com.example.uncwnavigatorapplication',
  );

  static const FirebaseOptions macos = FirebaseOptions(
    apiKey: 'AIzaSyAqYvoxR2BQOCnq3F6l0lK_jWMPIGtw9ds',
    appId: '1:942643978105:ios:2869be1d987d92c68f19a8',
    messagingSenderId: '942643978105',
    projectId: 'uncwnavigator',
    storageBucket: 'uncwnavigator.appspot.com',
    iosClientId: '942643978105-v6i1r6gq3u1bp11p07j9epn9uqlvh9bo.apps.googleusercontent.com',
    iosBundleId: 'com.example.uncwnavigatorapplication',
  );
}
