package com.citi.reactiveStream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Demo {
  public static void main(String[] args) {
    // 1.创建一个发布者
    SubmissionPublisher publisher = new SubmissionPublisher();

    // 2.创建一个订阅者
    Flow.Subscriber subscriber =
        new Flow.Subscriber() {
          Flow.Subscription subscription;

          @Override
          public void onSubscribe(Flow.Subscription subscription) {
            System.out.println("build relationship");
            this.subscription = subscription;
            subscription.request(1); // 第一次需要
          }

          @Override
          public void onNext(Object item) {
            System.out.println("get the message: " + item);

            subscription.request(10);
          }

          @Override
          public void onError(Throwable throwable) {
            System.out.println("onError");
          }

          @Override
          public void onComplete() {
            System.out.println("onComplete");
          }
        };

    // 3.建立订阅者
    publisher.subscribe(subscriber);

    // 4.发送数据
    publisher.submit("hello reacitve stream");

    publisher.submit("hahah");

    try {
      Thread.currentThread().join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
