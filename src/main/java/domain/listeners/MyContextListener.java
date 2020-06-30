package domain.listeners;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.model.*;

import javax.json.Json;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SaveFile.getSaveFile().getPlayerList().add(new Player("grimeway", "Human", "Paladin", 15, 18, 14, 1));

        ObjectMapper mapper = new ObjectMapper();

        ArrayList<Monster> monsters = null;
        List<Monster> monsterList = null;
        File monsterCompendium = new File("src/main/java/domain/listeners/MonsterCompendium.json");

        System.out.println(monsterCompendium);
        try {
            monsterList = mapper.readValue(new URL("https://dl.dropboxusercontent.com/s/iwz112i0bxp2n4a/5e-SRD-Monsters.json"), new TypeReference<List<Monster>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        MonsterManager.setAllMonsters(new ArrayList<Monster>(monsterList));

        List<User> userList = null;
//        File logins = new File("Logins.json");

        try {
            userList = mapper.readValue(new File("C:\\Users\\mkwan\\Documents\\School\\HBO ICT\\Vakken\\IPASS\\DMCompanion\\src\\main\\java\\domain\\listeners\\Logins.json"), new TypeReference<List<User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserManager.setAllUsers(new ArrayList<User>(userList));





    }

}
