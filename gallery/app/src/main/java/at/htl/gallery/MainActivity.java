package at.htl.gallery;

import static at.htl.gallery.GalleryApplication.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;

import javax.inject.Inject;

import at.htl.gallery.model.service.AlbumService;
import at.htl.gallery.ui.layout.MainView;
import at.htl.gallery.util.Config;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {
    @Inject
    MainView mainView;

    @Inject
    AlbumService albumService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Config.load(this);
        var base_url = Config.getProperty("backend.baseurl");
        Log.i(TAG, "onCreate: " + base_url);
        mainView.buildContent(this);
        albumService.getAll();
    }
}