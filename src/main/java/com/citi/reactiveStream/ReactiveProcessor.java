package com.citi.reactiveStream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveProcessor extends SubmissionPublisher<String>
    implements Flow.Processor<String, String> {
  private Flow.Subscription subscription;

  @Override
  public void subscribe(Flow.Subscriber subscriber) {}

  @Override
  public void onSubscribe(Flow.Subscription subscription) {
    System.out.println("Processor build relationship");
    this.subscription = subscription;
    this.subscription.request(1);
  }

  @Override
  public void onNext(String item) {
    System.out.println("Processor get message: " + item);
    this.submit(item.toUpperCase());//将数据发给订阅者
    this.subscription.request(1);
  }

  @Override
  public void onError(Throwable throwable) {}

  @Override
  public void onComplete() {}
}
