class Usuario{
  final String? id;
  final String nombreCompleto;
  final String email;
  final String? password;

  Usuario({
    this.id,
    required this.nombreCompleto,
    required this.email,
    this.password,
  });

  factory Usuario.fromJson(Map<String,dynamic> json){
    return Usuario(
      id: json['id'],
      nombreCompleto: json['nombreCompleto'],
      email: json['email'],
      password: json['password'],
    );
  }

  Map<String,dynamic> toJson(){
    return {
      'id': id,
      'nombreCompleto': nombreCompleto,
      'email': email,
      'password': password,
    };
  }

}