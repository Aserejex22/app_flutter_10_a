import 'package:flutter/material.dart';
import '../viewmodel/register_view_model.dart';
import 'package:provider/provider.dart';

class RegisterPage extends StatelessWidget{
  const RegisterPage({super.key});

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (_) => RegisterViewModel(),
      child: Scaffold(
        appBar: AppBar(title: const Text('Register')),
        body: Center(
          child: Consumer<RegisterViewModel>(
            builder: (context, viewModel, child) {
              return Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    TextField(
                      controller: viewModel.usernameController,
                      decoration: const InputDecoration(labelText: 'Username'),
                    ),
                    TextField(
                      controller: viewModel.emailController,
                      decoration: const InputDecoration(labelText: 'Email'),
                    ),
                    TextField(
                      controller: viewModel.passwordController,
                      decoration: const InputDecoration(labelText: 'Password'),
                      obscureText: true,
                    ),
                    const SizedBox(height: 20),
                    viewModel.isLoading
                      ? const CircularProgressIndicator()
                      : ElevatedButton(
                          onPressed: () async {
                            bool success = await viewModel.register(
                              nombreCompleto: viewModel.usernameController.text,
                              email: viewModel.emailController.text,
                              password: viewModel.passwordController.text,
                            );
                            if (success) {
                              ScaffoldMessenger.of(context).showSnackBar(
                                const SnackBar(content: Text('Registration Successful')),
                              );
                            } else if (viewModel.errorMessage != null) {
                              ScaffoldMessenger.of(context).showSnackBar(
                                SnackBar(content: Text('Error: ${viewModel.errorMessage}')),
                              );
                            }
                          },
                          child: const Text('Register'),
                      )
                  ],
                ),
              );
            }
          )
        )
      ),
    );
  }
}