package at.htl.facility_management.model;

import javax.inject.Inject;

import at.htl.facility_management.util.store.Store;

public class ModelStore extends Store<Model> {
    @Inject
    ModelStore() {
        super(Model.class, new Model());
    }

    public void setFacilities(Facility[] facilities) {
        apply(model -> model.facilities = facilities);
    }
}
