package com.citi.lamda;

import java.util.function.*;

public class Demo {
  public static void main(String[] args) {
    // Supplier没有输入，只有一个输出
    Supplier<String> supplier = () -> "This is supplier demo";
    System.out.println(supplier.get());

    // Consumer只有输入
    Consumer<String> consumer = i -> System.out.println("This is demo for " + i);
    consumer.accept("Conusmer");

    // Function 输入T 输出R
    Function<Integer, Integer> function = i -> i * i;
    System.out.println("Function demo " + function.apply(9));

    // UnaryOperator 输入输出都是T
    UnaryOperator<Integer> unaryOperator = i -> i * i;
    System.out.println("Function demo " + unaryOperator.apply(2));

    BiFunction<Integer, Integer, String> biFunction = (i, j) -> i + "*" + j + "=" + i * j;
    System.out.println(biFunction.apply(3, 5));
  }
}
