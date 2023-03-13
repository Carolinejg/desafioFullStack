import 'dart:convert';

import 'package:frontend/model/controle_estoque.dart';
import '../../../repository/i_controleestoque_repository.dart';
import 'package:http/http.dart' as http;

class ControleEstoqueRepository implements IControleEstoqueRepository{
  @override
  Future<List<ControleEstoqueModel>> findAllControleEstoque() async  {
    try {
      final response = await http.get(Uri.parse('http://localhost:8080/estoque'));
      final List<dynamic> responseMap = jsonDecode(response.body);
      return responseMap.map<ControleEstoqueModel>((resp) => ControleEstoqueModel.fromMap(resp)).toList();
} catch (e) {
    
    rethrow;
}
    
  }
  
}