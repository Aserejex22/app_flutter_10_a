import 'package:dio/dio.dart';
import '../model/usuario_model.dart';

class ApiService{
  final Dio _dio = Dio(BaseOptions(baseUrl:'http://10.0.2.2:8080/api'));

  Future<Usuario?> registerUser(Usuario usuario) async{
    try{
      Response response = await _dio.post(
        '/usuarios/registrar',
        data: usuario.toJson(),
      );
      if(response.statusCode == 201){
        return Usuario.fromJson(response.data);
      }else{
        throw DioException(
          requestOptions: response.requestOptions,
          response: response,
          error: 'Error al registrar usuario: ${response.statusMessage}'
        );
      }
    } on DioException catch(e){
      return Future.error('Error en la solicitud: ${e.message}');
    }
  }
}