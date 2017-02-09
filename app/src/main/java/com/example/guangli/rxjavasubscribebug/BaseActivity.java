package com.example.guangli.rxjavasubscribebug;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static com.example.guangli.rxjavasubscribebug.MockLowLevel.getData;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    Disposable mDisposable;
    @BindView(R.id.tv)
    TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createView());
    }

    protected abstract int createView();

    @Override
    protected void onResume() {
        super.onResume();
        mockSubscribe();
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                mockSubscribe();
            }
        }, 200);
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 500);
    }

    @Override
    public void finish() {
        super.finish();
        Log.d(TAG, "finish: ");
    }

    void mockSubscribe() {
        mDisposable = getData().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                mTv.setText(s);
            }
        });
        Log.d(TAG, "mockSubscribe: " + System.identityHashCode(mDisposable));
    }

    @Override
    protected void onPause() {
        super.onPause();
        DisposableUtils.disposable(mDisposable);
        mTv = null;
    }
}
