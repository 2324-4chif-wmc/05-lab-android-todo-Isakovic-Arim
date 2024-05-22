package at.htl.gallery.model;

import at.htl.gallery.model.entities.Album;

public class Model {
    public static class UIState {
        public int selectedTab = 0;
    }
    public Album[] albums = new Album[0];
    public UIState uiState = new UIState();
}
