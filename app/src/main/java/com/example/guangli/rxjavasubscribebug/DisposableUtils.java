package com.example.guangli.rxjavasubscribebug;

import android.util.Log;

import io.reactivex.disposables.Disposable;

public class DisposableUtils {
    private static final String TAG = "DisposableUtils";

    public static void disposable(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            Log.d(TAG, "disposable: " + System.identityHashCode(disposable));
            disposable.dispose();
        }
    }
}
