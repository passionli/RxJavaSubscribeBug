package com.example.guangli.rxjavasubscribebug;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class MockLowLevel {
    public static Observable<String> getData() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                }
                e.onNext("from low level : hello world");
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io());
    }
}
