// ignore_for_file: public_member_api_docs, sort_constructors_first
import 'dart:convert';

import 'package:frontend/model/filial.dart';
import 'package:frontend/model/produto.dart';

class ControleEstoqueModel {
  Produto produto;
  Filial filial;
  int quantidade;

  ControleEstoqueModel({
    required this.produto,
    required this.filial,
    required this.quantidade,
  });

  Map<String, dynamic> toMap() {
    return <String, dynamic>{
      'produto': produto,
      'filial': filial,
      'quantidade': quantidade,
    };
  }

  factory ControleEstoqueModel.fromMap(Map<String, dynamic> map) {
    return ControleEstoqueModel(
      produto: Produto.fromMap(map['produto']),
      filial: Filial.fromMap(map['filial']),
      quantidade: map['quantidade'] as int,
    );
  }

  String toJson() => json.encode(toMap());

  factory ControleEstoqueModel.fromJson(String source) => ControleEstoqueModel.fromMap(json.decode(source) as Map<String, dynamic>);
}
