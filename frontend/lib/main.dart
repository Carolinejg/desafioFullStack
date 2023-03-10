import 'package:flutter/material.dart';
import 'package:frontend/home/home_page.dart';
import 'package:frontend/home/http/http_page.dart';
import 'package:get/get.dart';

import 'home/http/http_bindings.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget { 
  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      getPages: [
        GetPage(
          name: '/', page: () => HomePage(),children: [
            GetPage(
              name: '/http', 
              page: () => HttpPage(),
              binding: HttpBindings(),
            )
          ])
      ],
    );
  }
}
