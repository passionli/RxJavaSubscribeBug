package com.example.guangli.rxjavasubscribebug;

public class RightWayActivity extends BaseActivity {
    private static final String TAG = "RightWayActivity";

    @Override
    protected int createView() {
        return R.layout.activity_right_way;
    }

    @Override
    void mockSubscribe() {
        //clear the previous instance
        DisposableUtils.disposable(mDisposable);
        super.mockSubscribe();
    }
}
