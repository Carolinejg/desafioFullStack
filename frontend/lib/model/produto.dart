// ignore_for_file: public_member_api_docs, sort_constructors_first
import 'dart:convert';

class Produto {
  String nome;

  Produto({
    required this.nome,
  });

  Map<String, dynamic> toMap() {
    return <String, dynamic>{
      'nome': nome,
    };
  }

  factory Produto.fromMap(Map<String, dynamic> map) {
    return Produto(
      nome: map['nome'] as String,
    );
  }

  String toJson() => json.encode(toMap());

  factory Produto.fromJson(String source) => Produto.fromMap(json.decode(source) as Map<String, dynamic>);
}
