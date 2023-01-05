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
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for ios - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      case TargetPlatform.macOS:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for macos - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
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
  // Should never hardcode sensitive keys in prod or a public repo.
  static const FirebaseOptions web = FirebaseOptions(
    apiKey: 'AIzaSyCGTJmH1cysAz5nDXqIu5sGqlubbDmJXH8',
    appId: '1:731063562821:web:b317f632a5d7079d65292c',
    messagingSenderId: '731063562821',
    projectId: 'paw-pals-uncw',
    authDomain: 'paw-pals-uncw.firebaseapp.com',
    storageBucket: 'paw-pals-uncw.appspot.com',
    measurementId: 'G-YEHCQLGWV1',
  );

  static const FirebaseOptions android = FirebaseOptions(
    apiKey: 'AIzaSyCbvUYTUsl3YqWpgzB3gJ_REhmZ5iisWHQ',
    appId: '1:731063562821:android:39afce2999ba79d365292c',
    messagingSenderId: '731063562821',
    projectId: 'paw-pals-uncw',
    storageBucket: 'paw-pals-uncw.appspot.com',
  );
}