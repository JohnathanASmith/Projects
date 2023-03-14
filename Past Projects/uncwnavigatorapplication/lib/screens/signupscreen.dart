import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:uncwnavigatorapplication/constants/app_colors.dart';
import 'package:uncwnavigatorapplication/constants/reg_expressions.dart';
import 'package:uncwnavigatorapplication/models/user_model.dart';
import 'package:uncwnavigatorapplication/screens/homescreen.dart';

class SignUpScreen extends StatefulWidget {
  const SignUpScreen({super.key});

  @override
  State<SignUpScreen> createState() => _SignUpScreenState();
}

class _SignUpScreenState extends State<SignUpScreen> {
  final userRef = FirebaseFirestore.instance.collection('users');
  String? email;
  String? password;
  String? password2;
  String? error;
  String? firstName;
  String? lastName;
  String? username;
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    void trySignup() async {
      try {
        // The await keyword blocks execution to wait for
        // signInWithEmailAndPassword to complete its asynchronous execution and
        // return a result.
        //
        // FirebaseAuth with raise an exception if the email or password
        // are determined to be invalid, e.g., the email doesn't exist.
        final credential = await FirebaseAuth.instance
            .createUserWithEmailAndPassword(email: email!, password: password!);
        print("Logged in ${credential.user}");
        UserModel user = UserModel(uid: FirebaseAuth.instance.currentUser!.uid,
        email: email,
        first: firstName,
        last: lastName,
        username: username,
        photoUrl: '');

        DocumentReference doc = await userRef.add(user.toMap());

        error = null; // clear the error message if exists.
        setState(() {}); // Call setstate to trigger a rebuild

        // We need this next check to use the Navigator in an async method.
        // It basically makes sure LoginScreen is still visible.
        if (!mounted) return;

        // pop the navigation stack so people cannot "go back" to the login screen
        // after logging in.
        Navigator.of(context).pop();
        // Now go to the HomeScreen.
        Navigator.of(context).push(MaterialPageRoute(
          builder: (context) => const HomeScreen(),
        ));
      } on FirebaseAuthException catch (e) {
        // Exceptions are raised if the Firebase Auth service
        // encounters an error. We need to display these to the user.
        print(e);
        if (e.code == 'email-already-in-use') {
          error = 'Email already taken';
        }

        // Call setState to redraw the widget, which will display
        // the updated error text.
        setState(() {});
      }
    }

    return Scaffold(
      backgroundColor: AppColors.primary,
      body: SingleChildScrollView(
        padding: EdgeInsets.fromLTRB(0, 80, 0, 30),
          child: Padding(
        padding: const EdgeInsets.all(16),
        child: Form(
          key: _formKey,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              Container(
                padding: EdgeInsetsDirectional.only(start: 16, end: 16),
                decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(30),
                    border: Border.all(width: 3)),
                child: Column(children: [

                  TextFormField(
                    cursorColor: AppColors.primary,
                  decoration:
                      const InputDecoration(
                        enabledBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color: Colors.teal),
                            ),
                            focusedBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                            border: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                        hintText: 'Enter your first name'),
                  maxLength: 64,
                  onChanged: (value) => firstName = value,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter some text';
                    }
                    return null; // Returning null means "no issues"
                  }),
                  TextFormField(
                    cursorColor: AppColors.primary,
                  decoration:
                      const InputDecoration(
                        enabledBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color: Colors.teal),
                            ),
                            focusedBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                            border: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                        hintText: 'Enter your last name'),
                  maxLength: 64,
                  onChanged: (value) => lastName = value,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter some text';
                    }
                    return null; // Returning null means "no issues"
                  }),
                  TextFormField(
                    cursorColor: AppColors.primary,
                  decoration:
                      const InputDecoration(
                        enabledBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color: Colors.teal),
                            ),
                            focusedBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                            border: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                        hintText: 'Enter your username'),
                  maxLength: 64,
                  onChanged: (value) => username = value,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter some text';
                    }
                    return null; // Returning null means "no issues"
                  }),
                  TextFormField(
                    cursorColor: AppColors.primary,
                  decoration:
                      const InputDecoration(
                        enabledBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color: Colors.teal),
                            ),
                            focusedBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                            border: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                        hintText: 'Enter your email'),
                  maxLength: 64,
                  onChanged: (value) => email = value,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter some text';
                    }
                    if (!RegExpressions.email.hasMatch(value)) {
                      return 'Invalid email.';
                    }
                    return null; // Returning null means "no issues"
                  }),
              TextFormField(
                cursorColor: AppColors.primary,
                  decoration:
                      const InputDecoration(
                        enabledBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color: Colors.teal),
                            ),
                            focusedBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                            border: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                        hintText: "Enter a password"),
                  obscureText: true,
                  onChanged: (value) => password = value,
                  validator: (value) {
                    if (value == null || value.length < 8 || value.isEmpty) {
                      return 'Your password must contain at least 8 characters.';
                    }
                    return null; // Returning null means "no issues"
                  }),
              const SizedBox(height: 16),
              TextFormField(
                cursorColor: AppColors.primary,
                  decoration:
                      const InputDecoration(
                        enabledBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color: Colors.teal),
                            ),
                            focusedBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                            border: UnderlineInputBorder(
                              borderSide: BorderSide(color:  Colors.teal),
                            ),
                        hintText: "Re-enter a password"),
                  obscureText: true,
                  onChanged: (value) => password2 = value,
                  validator: (value) {
                    if (value == null || value.length < 8 || value.isEmpty) {
                      return 'Your password must contain at least 8 characters.';
                    } else if (password != password2) {
                      return 'Passwords do not match.';
                    }
                    return null; // Returning null means "no issues"
                  }),
              const SizedBox(height: 16),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                ElevatedButton(
                  style: ButtonStyle(
                                backgroundColor: MaterialStateProperty.all(
                                    AppColors.primaryAccent)),
                  child: const Text('Sign Up'),
                  onPressed: () {
                    if (_formKey.currentState!.validate()) {
                      // This calls all validators() inside the form for us.
                      trySignup();
                    }
                  }),
              if (error != null)
                Text(
                  "Error: $error",
                  style: TextStyle(color: Colors.red[800], fontSize: 12),
                ),
              const SizedBox(height: 16),
              ElevatedButton(
                style: ButtonStyle(
                                backgroundColor: MaterialStateProperty.all(
                                    AppColors.primaryAccent)),
                  child: const Text('Back to Login'),
                  onPressed: () {
                    Navigator.maybePop(context);
                  }),
              ],),
              const SizedBox(height: 16),
              ],)),
            ],
          ),
        ),
      )),
    );
  }
}
