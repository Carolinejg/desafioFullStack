import 'package:flutter/material.dart';
import 'package:frontend/home/http/htpp_controller.dart';
import 'package:get/get_state_manager/get_state_manager.dart';

import '../../model/controle_estoque.dart';

class HttpPage extends GetView<HttpController> {
  
  @override
   Widget build(BuildContext context) {
       return Scaffold(
           // ignore: prefer_const_constructors
           appBar: AppBar(title: Text('Http'),),
           body: controller.obx((state) {
             return ListView.builder(
               itemCount: state.length,
               itemBuilder: (_, index){
                 final ControleEstoqueModel item = state[index];
                 return Text('Filial:'+ item.filial.endereco+ ' Produto:'+ item.produto.nome+' Quantidade:'+ item.quantidade.toString());
                   
                 
               },
             );
           }, onError: (error) {
             return SizedBox(
               width: double.infinity,
               child: Column(
                 mainAxisAlignment: MainAxisAlignment.center,
                 children: [
                   Text(error ?? ''),
                   TextButton(
                     onPressed: () => controller.findControleEstoque(),
                     // ignore: prefer_const_constructors
                     child: Text('Tentar novamente'),
                   )
                 ],
               ),
             );
           }),
       );
  }
}


 