package domain.webservices;

import domain.model.Player;
import domain.model.SaveFile;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.StringReader;

@Path("/players")
public class PlayerResource {

    @GET
    @Path("/managed-players")
    @Produces("application/json")
    public Response getPlayers() {
        return Response.ok(SaveFile.getSaveFile().getPlayerList()).build();
    }

    @POST
    @Path("/player")
    @Consumes("application/json")
    @Produces("application/json")
    public String createPlayer(String jsonBody) {
        StringReader stringReader = new StringReader(jsonBody);
        JsonObject structure = Json.createReader(stringReader).readObject();

        String playerName = structure.getString("playerName");
        String playerRace = structure.getString("playerRace");
        String playerClass = structure.getString("playerClass");
        int playerHealth = Integer.parseInt(structure.getString("playerHealth"));
        int playerAC = Integer.parseInt(structure.getString("playerAC"));
        int playerPP = Integer.parseInt(structure.getString("playerPP"));
        int playerInitiative = Integer.parseInt(structure.getString("playerInitiative"));

        SaveFile.getSaveFile().getPlayerList().add(new Player(playerName, playerRace, playerClass, playerHealth, playerAC, playerPP, playerInitiative));

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        jsonObjectBuilder.add("message", structure);

        return jsonObjectBuilder.build().toString();
    }

    @DELETE
    @Path("/{id}")
    public void deletePlayer(@PathParam("id") String playerName) {
        SaveFile.getSaveFile().removePlayer(playerName);
    }
}
