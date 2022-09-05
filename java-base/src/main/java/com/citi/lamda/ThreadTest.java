package com.citi.lamda;

public class ThreadTest {
  private static ThreadLocal<String> currentThreadLocal = new ThreadLocal<String>();

  static void printThreadInfo(String str) {
    System.out.println(str + ":" + currentThreadLocal.get());
    currentThreadLocal.remove();
  }

  public static void main(String[] args) throws InterruptedException {

    new Thread(
            () -> {
              ThreadTest.currentThreadLocal.set("Thread_A");
              printThreadInfo("A");
              System.out.println("After remove: " + currentThreadLocal.get());
            },
            "A")
        .start();

    Thread.sleep(1000);

    new Thread(
            () -> {
              ThreadTest.currentThreadLocal.set("Thread_B");
              printThreadInfo("B");
              System.out.println("After remove: " + currentThreadLocal.get());
            },
            "B")
            .start();
  }
}
