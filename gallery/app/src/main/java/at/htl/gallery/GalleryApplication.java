package at.htl.gallery;

import android.app.Application;
import android.util.Log;

import javax.inject.Singleton;

import dagger.hilt.android.HiltAndroidApp;

@Singleton
@HiltAndroidApp
public class GalleryApplication extends Application {
    static final String TAG = GalleryApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "App started ...");
    }
}
