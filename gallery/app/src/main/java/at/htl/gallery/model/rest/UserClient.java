package at.htl.gallery.model.rest;

import at.htl.gallery.model.entities.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
public interface UserClient {
    @GET
    User[] all();
}
