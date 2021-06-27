package domain.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {


        ObjectMapper mapper = new ObjectMapper();

        ArrayList<Monster> monsters = null;
        List<Monster> monsterList = null;


        try {
            monsterList = mapper.readValue(new URL("https://dl.dropboxusercontent.com/s/iwz112i0bxp2n4a/5e-SRD-Monsters.json"), new TypeReference<List<Monster>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        MonsterManager.setAllMonsters(new ArrayList<Monster>(monsterList));

        List<User> userList = null;

        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("Logins.json")) {
            //pass InputStream to JSON-Library, e.g. using Jackson
            JsonNode jsonNode = mapper.readValue(in,
                    JsonNode.class);
            String jsonString = mapper.writeValueAsString(jsonNode);
            System.out.println(jsonString);
            userList = mapper.readValue(jsonString, new TypeReference<List<User>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        UserManager.setAllUsers(new ArrayList<User>(userList));


    }
}
