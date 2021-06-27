package domain.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

//        File file = new File(".");
//        for(String fileNames : file.list()) System.out.println(fileNames);

//        File file = new File("")
//
//        InputStream idk = Thread.currentThread().getContextClassLoader().getResourceAsStream("src/Logins.json");
//
//        StringBuilder textbuilder = new StringBuilder();
//        try (Reader reader = new BufferedReader(new InputStreamReader(idk, Charset.forName(StandardCharsets.UTF_8.name())))) {
//            int c = 0;
//            while ((c = reader.read()) != -1) {
//                textbuilder.append((char) c);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        System.out.println(textbuilder);


        try {
            userList = mapper.readValue(new File("Logins.json"), new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            File file = new File("Logins.json");
            try {
                System.out.println("Attempting to read from file in: " + file.getCanonicalPath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

        UserManager.setAllUsers(new ArrayList<User>(userList));

    }

}
