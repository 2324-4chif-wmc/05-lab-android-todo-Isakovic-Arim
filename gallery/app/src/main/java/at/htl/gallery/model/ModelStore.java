package at.htl.gallery.model;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.htl.gallery.model.entities.Album;
import at.htl.gallery.util.store.Store;

@Singleton
public class ModelStore extends Store<Model> {
    @Inject
    ModelStore() {
        super(Model.class, new Model());
    }

    public void setAlbums(Album[] albums) {
        apply(model -> model.albums = albums);
    }
    public void selectTab(int tabIndex) { apply(model -> model.uiState.selectedTab = tabIndex); }
}
