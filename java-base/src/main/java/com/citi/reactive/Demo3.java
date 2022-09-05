package com.citi.reactive;

import reactor.core.publisher.Flux;

public class Demo3 {
  public static void main(String[] args) {
    // 输入hello guys i am blair welcome to normal school jdk
    // 输出：abcdffghijk

    String src = "hello guys i am blair welcome to normal school jdk";
    Flux.fromArray(src.split(" "))
        .flatMap(i -> Flux.fromArray(i.split("")))
        .distinct()
        .sort()
        .subscribe(System.out::println);
  }
}
