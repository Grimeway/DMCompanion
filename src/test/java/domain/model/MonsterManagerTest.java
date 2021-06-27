package domain.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.junit.Assert;

import javax.validation.constraints.AssertTrue;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MonsterManagerTest extends TestCase {

    List<Monster> monsterList = null;


    public void setUp() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        try {
            monsterList = mapper.readValue(new URL("https://dl.dropboxusercontent.com/s/iwz112i0bxp2n4a/5e-SRD-Monsters.json"), new TypeReference<List<Monster>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        MonsterManager.setAllMonsters(new ArrayList<Monster>(monsterList));
        super.setUp();
    }


    public void testGetMonster() {
        Monster monster = MonsterManager.getMonster("Imp");
        assertEquals("Imp", monster.getName());
    }

}