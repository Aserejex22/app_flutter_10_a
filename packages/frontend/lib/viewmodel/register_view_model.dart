import 'package:flutter/material.dart';
import 'package:frontend/model/usuario_model.dart';
import '../service/api_service.dart';
import 'package:provider/provider.dart';

class RegisterViewModel extends ChangeNotifier{
  final ApiService _apiService = ApiService();
  bool _isLoading = false;
  String? _errorMessage;

  bool get isLoading => _isLoading;
  String? get errorMessage => _errorMessage;

  Future<bool> register({
    required String nombreCompleto,
    required String email,
    required String password,
  })async{
    _isLoading = true;
    _errorMessage = null;
    notifyListeners();
    try {
      Usuario newUsuario = Usuario(
        nombreCompleto: nombreCompleto, 
        email: email,
        password: password
      );
      Usuario? registeredUser = await _apiService.registerUser(newUsuario);
      _isLoading = false;
      notifyListeners();
      return registeredUser != null;
    } catch (e) {
      _isLoading=false;
      _errorMessage = e.toString();
      notifyListeners();
      return false;
    }
  }

}