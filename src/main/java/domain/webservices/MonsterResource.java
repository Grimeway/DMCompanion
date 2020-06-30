package domain.webservices;


import com.azure.core.annotation.QueryParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.model.Monster;
import domain.model.MonsterManager;


import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.StringReader;

@Path("/monsters")
public class MonsterResource {

    @GET
    @Path("/monster/{name}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getMonster(@PathParam( "name" ) String name) {
        return Response.ok(MonsterManager.getMonster(name)).build();
    }

    @GET
    @Path("/managed-monsters")
    @Produces("application/json")
    public Response getMonsterList(){
        return Response.ok(MonsterManager.getMonsterList()).build();
    }

    @DELETE
    @Path("/{monsterName}")
    public void deleteMonster(@PathParam("monsterName") String monsterName) {
        MonsterManager.deleteMonster(monsterName);
    }
}
