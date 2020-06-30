package domain.webservices;

import domain.model.Player;
import domain.model.SaveFile;
import domain.model.User;
import domain.model.UserManager;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;

@Path("/login")
public class UserResource {

    @GET
    @Path("/user/{login}/{password}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response checkLogin(@PathParam( "login" ) String login, @PathParam( "password" ) String password) {
        boolean userCheck = UserManager.checkUser(login, password);
        if (userCheck) {
            return Response.ok(true).build();
        }
        return Response.status(400).entity(false).type("application/json").build();
    }

    @POST
    @Path("/managed-login")
    @Consumes("application/json")
    @Produces("application/json")
    public String createPlayer(String jsonBody) {
        StringReader stringReader = new StringReader(jsonBody);
        JsonObject structure = Json.createReader(stringReader).readObject();

        String login = structure.getString("login");
        String password = structure.getString("password");

        UserManager.getAllUsers().add(new User(login, password));

        //write to json file
        UserManager.getUserManager().writeToFile();

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        jsonObjectBuilder.add("message", structure);

        return jsonObjectBuilder.build().toString();
    }
}
