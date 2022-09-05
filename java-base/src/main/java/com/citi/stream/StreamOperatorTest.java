package com.citi.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class StreamOperatorTest {

  public static void main(String[] args) {
    String[] arr = {"Jonathan", "Elsa", "Blair"};

    // 1.数组方式创建
    Arrays.stream(arr).forEach(System.out::println);

    // 2. list
    Arrays.asList(arr).stream().forEach(System.out::println);

    // 3.Stream.of
    Stream.of(arr).forEach(System.out::println);

    // 4. 迭代器
    Stream.iterate(1, i -> i + 1).limit(2).forEach(System.out::println);

    // 5.generate
    Stream.generate(() -> new Random().nextInt(10)).limit(2).forEach(System.out::println);
  }
}
