// ignore_for_file: public_member_api_docs, sort_constructors_first
import 'dart:convert';

import 'package:frontend/model/filial.dart';
import 'package:frontend/model/produto.dart';

class ControleEstoqueModel {
  List<Produto> produto;
  List<Filial> filial;
  int quantidade;

  ControleEstoqueModel({
    required this.produto,
    required this.filial,
    required this.quantidade,
  });

  Map<String, dynamic> toMap() {
    return <String, dynamic>{
      'produto': produto.map((x) => x.toMap()).toList(),
      'filial': filial.map((x) => x.toMap()).toList(),
      'quantidade': quantidade,
    };
  }

  factory ControleEstoqueModel.fromMap(Map<String, dynamic> map) {
    return ControleEstoqueModel(
      produto: List<Produto>.from((map['produto'] as List<int>).map<Produto>((x) => Produto.fromMap(x as Map<String,dynamic>),),),
      filial: List<Filial>.from((map['filial'] as List<int>).map<Filial>((x) => Filial.fromMap(x as Map<String,dynamic>),),),
      quantidade: map['quantidade'] as int,
    );
  }

  String toJson() => json.encode(toMap());

  factory ControleEstoqueModel.fromJson(String source) => ControleEstoqueModel.fromMap(json.decode(source) as Map<String, dynamic>);
}
