package com.citi.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

public class Demo {

  public static void main(String[] args) {
    // Mono的创建方式
    // Mono.empty().subscribe(System.out::println);
    Mono.just("hello mono").subscribe(System.out::println);

    // Flux创建方式 0-n个元素xulie
    Flux.just(1, 2, 3, 4, 5).subscribe(System.out::println);
    Flux.fromIterable(Arrays.asList("a", "b", "c", "d")).subscribe(System.out::println);

    Flux.generate(
            () -> 0,
            (i, sink) -> {
              sink.next("2*" + i + "=" + 2 * i);
              if (i == 9) sink.complete();
              return i + 1;
            })
        .subscribe(System.out::println);
  }
}
