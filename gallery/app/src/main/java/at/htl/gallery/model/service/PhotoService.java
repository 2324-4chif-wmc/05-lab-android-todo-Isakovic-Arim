package at.htl.gallery.model.service;

import android.util.Log;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.htl.gallery.model.ModelStore;
import at.htl.gallery.model.rest.AlbumClient;
import at.htl.gallery.model.rest.PhotoClient;
import at.htl.gallery.util.resteasy.RestApiClientBuilder;

@Singleton
public class PhotoService {
    static final String TAG = PhotoService.class.getSimpleName();
    public static String JSON_PLACEHOLDER_BASE_URL = "https://jsonplaceholder.typicode.com";
    public final PhotoClient photoClient;
    public final ModelStore store;

    @Inject
    PhotoService(RestApiClientBuilder builder, ModelStore store) {
        Log.i(TAG, "Creating TodoService with base url: " + JSON_PLACEHOLDER_BASE_URL);
        photoClient = builder.build(PhotoClient.class, JSON_PLACEHOLDER_BASE_URL);
        this.store = store;
    }
}
