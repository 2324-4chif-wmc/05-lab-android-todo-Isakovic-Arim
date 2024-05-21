package at.htl.facility_management;

import android.app.Application;
import android.util.Log;

import javax.inject.Singleton;

import dagger.hilt.android.HiltAndroidApp;

@Singleton
@HiltAndroidApp
public class FacilityMgmtApplication extends Application {
    static final String TAG = FacilityMgmtApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "App started ...");
    }
}
