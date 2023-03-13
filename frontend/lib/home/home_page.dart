// ignore_for_file: prefer_const_constructors, duplicate_ignore

import 'package:flutter/material.dart';
import 'package:get/get.dart';

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // ignore: duplicate_ignore, duplicate_ignore, duplicate_ignore
      appBar: AppBar(
        // ignore: prefer_const_constructors
        title: Text('Controle de Estoque'),
      ),
     
      // ignore: sized_box_for_whitespace
      body: Container(
        width: double.infinity,
        child: Column(
          mainAxisAlignment:MainAxisAlignment.center,
          children: [
            TextButton(
              onPressed: () => Get.toNamed('/http'),
              // ignore: prefer_const_constructors
              child: Text(
                'Estoques',
                style: TextStyle(fontSize: 20),
              ),
            )
          ],
        ),
      ),
    );
  }
}
