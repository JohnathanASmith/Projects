import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:uncwnavigatorapplication/constants/app_colors.dart';
import 'package:uncwnavigatorapplication/constants/app_data.dart';
import 'package:uncwnavigatorapplication/constants/reg_expressions.dart';
import 'package:uncwnavigatorapplication/screens/homescreen.dart';
import 'package:uncwnavigatorapplication/screens/signupscreen.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  String? email;
  String? password;
  String? error;
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    void tryLogin() async {
      try {
        // The await keyword blocks execution to wait for
        // signInWithEmailAndPassword to complete its asynchronous execution and
        // return a result.
        //
        // FirebaseAuth with raise an exception if the email or password
        // are determined to be invalid, e.g., the email doesn't exist.
        final credential = await FirebaseAuth.instance
            .signInWithEmailAndPassword(email: email!, password: password!);
        print("Logged in ${credential.user}");
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
        if (e.code == 'user-not-found') {
          error = 'No user found for that email.';
        } else if (e.code == 'wrong-password') {
          error = 'Wrong password provided for that user.';
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
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Container(
                padding: EdgeInsetsDirectional.only(start: 16, end: 16),
                decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(90),
                    border: Border.all(width: 3)),
                child: Icon(Icons.near_me, color: AppColors.primaryAccent, size: 160,)
              ),
              const SizedBox(height: 16),
              Container(
                padding: EdgeInsetsDirectional.only(start: 16, end: 16),
                decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(30),
                    border: Border.all(width: 3)),
                child: Column(
                  children: [
                    const SizedBox(height: 16),
                    TextFormField(
                      cursorColor: AppColors.primary,
                        decoration: const InputDecoration(
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
                          if (value == null ||
                              value.length < 8 ||
                              value.isEmpty) {
                            return 'Your password must contain at least 8 characters.';
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
                            child: const Text('Login'),
                            onPressed: () {
                              if (_formKey.currentState!.validate()) {
                                // This calls all validators() inside the form for us.
                                tryLogin();
                              }
                            }),
                        ElevatedButton(
                            style: ButtonStyle(
                                backgroundColor: MaterialStateProperty.all(
                                    AppColors.primaryAccent)),
                            child: const Text('Sign Up'),
                            onPressed: () {
                              Navigator.of(context).push(MaterialPageRoute(
                                builder: (context) => const SignUpScreen(),
                              ));
                            }),
                      ],
                    ),
                    const SizedBox(height: 16),
                  ],
                ),
              ),
              if (error != null)
                Text(
                  "Error: $error",
                  style: TextStyle(color: Colors.red[800], fontSize: 12),
                )
            ],
          ),
        ),
      )),
    );
  }
}
