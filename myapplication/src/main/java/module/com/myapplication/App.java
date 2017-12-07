package module.com.myapplication;

import android.app.Application;

import com.android.mj.*;
import com.android.mj.BuildConfig;

/**
 * author: Rea.X
 * date: 2017/12/2.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Library.init(this,null, BuildConfig.DEBUG);
    }
}
