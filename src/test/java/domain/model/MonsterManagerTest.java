package domain.model;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.model.Monster;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class MonsterManagerTest {
    private ArrayList<Monster> monsterList = new ArrayList<>();

    @BeforeAll
    void intializeTest() {
        ObjectMapper mapper = new ObjectMapper();
        List<Monster> monsterList = null;

        try {
            monsterList = mapper.readValue(new URL("https://dl.dropboxusercontent.com/s/iwz112i0bxp2n4a/5e-SRD-Monsters.json"), new TypeReference<List<Monster>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        MonsterManager.setAllMonsters(new ArrayList<Monster>(monsterList));
    }

    @Test
    void testGetMonster() {
        
    }
}