package at.htl.todo.model;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/todos")
@Consumes(MediaType.APPLICATION_JSON)
public interface TodoClient {
    @GET
    Todo[] all();

    @POST
    Todo create(Todo newTodo);
}

