package com.citi.reactiveStream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Demo2 {
  public static void main(String[] args) {
    //
    SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

    ReactiveProcessor processor = new ReactiveProcessor();
    publisher.subscribe(processor);

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

    processor.subscribe(subscriber);

    for (int i = 0; i < 500; i++) {
      System.out.println("Publish data: " + i);
      publisher.submit("Blair: " + i);
    }
    publisher.close();
    try {
      Thread.currentThread().join(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
