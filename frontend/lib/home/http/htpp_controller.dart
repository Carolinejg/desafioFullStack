

import 'package:get/get.dart';

import '../../repository/i_controleestoque_repository.dart';

class HttpController extends GetxController with StateMixin{

  final IControleEstoqueRepository _httpRepository;

  HttpController(this._httpRepository);

  @override
  void onInit() {
    // ignore: todo
    // TODO: implement onInit
    super.onInit();
    findControleEstoque();
  }
  
  Future<void> findControleEstoque() async {
    change([], status: RxStatus.loading());

    try {
      final dados = await _httpRepository.findAllControleEstoque();
      change(dados, status: RxStatus.success());
    }catch (e) {
        change([], status: RxStatus.error('Erro ao buscar controle'));
    }

  }

}