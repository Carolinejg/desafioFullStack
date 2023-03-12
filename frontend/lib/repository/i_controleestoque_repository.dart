import '../model/controle_estoque.dart';

abstract class IControleEstoqueRepository{
  Future<List<ControleEstoqueModel>>findAllControleEstoque();
}