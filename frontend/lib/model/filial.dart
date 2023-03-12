// ignore_for_file: public_member_api_docs, sort_constructors_first
import 'dart:convert';

class Filial {
  String endereco;

  Filial({
    required this.endereco,
  });

  Map<String, dynamic> toMap() {
    return <String, dynamic>{
      'endereco': endereco,
    };
  }

  factory Filial.fromMap(Map<String, dynamic> map) {
    return Filial(
      endereco: map['endereco'] as String,
    );
  }

  String toJson() => json.encode(toMap());

  factory Filial.fromJson(String source) => Filial.fromMap(json.decode(source) as Map<String, dynamic>);
}
