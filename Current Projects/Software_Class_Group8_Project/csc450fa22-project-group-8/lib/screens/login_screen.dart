import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:paw_pals/screens/sign_up_screen.dart';
import 'package:paw_pals/widgets/wrappers/field_wrapper.dart';

import '../utils/app_localizations.dart';
import '../widgets/forms/login_form.dart';
import '../widgets/wrappers/form_wrapper.dart';

class LoginScreen extends StatelessWidget {
  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();

  LoginScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(AppLocalizations.of(context).translate("page-titles.login")),
      ),
      body: SingleChildScrollView(
        child: FormWrapper(
            children: [
              const LoginForm(),
              FieldWrapper(
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Expanded(
                        child: TextButton(
                          style: ButtonStyle(
                            padding: MaterialStateProperty.all(
                                const EdgeInsets.symmetric(vertical: 18.0)
                            ),
                          ),
                          onPressed: () {
                            // TODO: Implement password recovery.
                            print("'Forgot password?' button pressed.");
                          },
                          child: Text(AppLocalizations.of(context).translate("btn-labels.forgot-password")),
                        ),
                      ),
                      Expanded(
                        child: OutlinedButton(
                          style: ButtonStyle(
                            side: MaterialStateProperty.all(
                                BorderSide(color: Theme.of(context).colorScheme.primary, width: 2.0)
                            ),
                            padding: MaterialStateProperty.all(
                                const EdgeInsets.symmetric(vertical: 18.0)
                            ),
                          ),
                          onPressed: () {
                            Get.to(() => const SignUpScreen());
                          },
                          child: Text(AppLocalizations.of(context).translate("btn-labels.sign-up")),
                        ),
                      )
                    ],
                  )
              )
            ]
        ),
      )
    );
  }
}