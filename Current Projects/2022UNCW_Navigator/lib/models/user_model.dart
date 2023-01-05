import 'package:cloud_firestore/cloud_firestore.dart';

class UserModel {
  UserModel(
      {required this.uid,
      this.username,
      this.email,
      this.first,
      this.last,
      required this.photoUrl});

  final String? uid;
  String? email;
  String? username;
  String? first;
  String? last;
  String photoUrl;

  Map<String, Object?> toMap() {
    // The { } create a Map object, much like { } in Python creates a dictionary
    // This method creates and immediately returns the map.
    return {
      'uid': uid,
      'username': username,
      'photoUrl': photoUrl,
      'first': first,
      // 'visited': visited
      'last': last,
      'email': email,
    };
  }
}

UserModel get fakeUserData => UserModel(
    uid: '',
    email: "jas2647@uncw.edu",
    first: "Johnathan",
    last: "Smith",
    username: "jas2647",
    photoUrl: "");
