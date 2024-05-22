package at.htl.gallery.model.service;

import android.util.Log;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.htl.gallery.model.ModelStore;
import at.htl.gallery.model.rest.AlbumClient;
import at.htl.gallery.util.resteasy.RestApiClientBuilder;

@Singleton
public class AlbumService {
    static final String TAG = AlbumService.class.getSimpleName();
    public static String JSON_PLACEHOLDER_BASE_URL = "https://jsonplaceholder.typicode.com";
    public final AlbumClient todoClient;
    public final ModelStore store;

    @Inject
    AlbumService(RestApiClientBuilder builder, ModelStore store) {
        Log.i(TAG, "Creating TodoService with base url: " + JSON_PLACEHOLDER_BASE_URL);
        todoClient = builder.build(AlbumClient.class, JSON_PLACEHOLDER_BASE_URL);
        this.store = store;
    }

    public void getAll() {
        CompletableFuture
                .supplyAsync(() -> todoClient.all())
                .thenAccept(store::setAlbums)
                .exceptionally((e) -> {
                    Log.e(TAG, "Error loading todos", e);
                    return null;
                });
    }
}
