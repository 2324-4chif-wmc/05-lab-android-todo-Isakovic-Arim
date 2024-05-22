package at.htl.gallery.model.service;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.htl.gallery.model.ModelStore;
import at.htl.gallery.model.rest.PhotoClient;
import at.htl.gallery.model.rest.UserClient;
import at.htl.gallery.util.resteasy.RestApiClientBuilder;

@Singleton
public class UserService {
    public static String TAG = UserService.class.getSimpleName();
    public static String JSON_PLACEHOLDER_BASE_URL = "https://jsonplaceholder.typicode.com";
    public final UserClient userClient;
    public final ModelStore store;

    @Inject
    UserService(RestApiClientBuilder builder, ModelStore store) {
        Log.i(TAG, "Creating UserService with base url: " + JSON_PLACEHOLDER_BASE_URL);
        userClient = builder.build(UserClient.class, JSON_PLACEHOLDER_BASE_URL);
        this.store = store;
    }
}
