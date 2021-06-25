package domain.webservices;

import domain.model.Player;
import domain.model.SaveFile;
import domain.model.User;
import domain.model.UserManager;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
    public Response checkLogin(@PathParam("login") String login, @PathParam("password") String password) {
        boolean userCheck = UserManager.checkUser(login, password);
        if (userCheck) {
            return Response.ok(true).build();
        }
        return Response.status(400).entity(false).type("application/json").build();
    }

    @POST
    @Path("/user/{login}/{password}")
    public User login(@PathParam("login") String username, @PathParam("password") String pwd) {

        String token = getJWTToken(username);
        User user = new User();
        user.setLogin(username);
        user.setToken(token);
        return user;
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }



//    @POST
//    @Path("/managed-login")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public String createUser (String jsonBody){
//        StringReader stringReader = new StringReader(jsonBody);
//        JsonObject structure = Json.createReader(stringReader).readObject();
//
//        String login = structure.getString("login");
//        String password = structure.getString("password");
//
//        UserManager.getAllUsers().add(new User());
//
//        //write to json file
//        UserManager.getUserManager().writeToFile();
//
//        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
//        jsonObjectBuilder.add("message", structure);
//
//        return jsonObjectBuilder.build().toString();
//    }
}
