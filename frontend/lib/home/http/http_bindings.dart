import 'package:frontend/home/http/htpp_controller.dart';
import 'package:frontend/home/http/repository/controle_estoque_repository.dart';
import 'package:get/get.dart';

import '../../repository/i_controleestoque_repository.dart';

class HttpBindings implements Bindings{
  @override
  void dependencies(){
    Get.put<IControleEstoqueRepository>(ControleEstoqueRepository());
    Get.put(HttpController(Get.find()));
  }
}