package com.citi.stream;

import java.util.stream.Stream;

public class StreamOperatorTestB {
  public static void main(String[] args) {
    //
      String[] arr = { "react", "a_ngular", "singleAPP", "spring", "react", "angular", "singleAPP", "spring"};

    Stream.of(arr)
        .filter(i -> (!i.isEmpty())) // 留编程中 必须要有一个终止的操作, 终止操作只能有一个
        //.peek(i -> System.out.println(i))// peek是一个中间操作，可以用来调试，
            .distinct()
            .sorted()
            .limit(1)
            .map(i->i.replace("_",""))
            .flatMap(i->Stream.of(i.split("")))
            .sorted()
            .forEach(System.out::println);
  }
}
