package at.htl.gallery.model.rest;

import at.htl.gallery.model.entities.Album;
import at.htl.gallery.model.entities.Photo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/albums")
@Consumes(MediaType.APPLICATION_JSON)
public interface AlbumClient {
    @GET
    Album[] all();

    @GET
    @Path("/:id/photos")
    Photo[] allPhotos();
}
