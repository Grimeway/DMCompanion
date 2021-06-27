package domain.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonsterManagerTest {
    private ArrayList<Monster> monsterList = new ArrayList<>();

    public void setMonsterList(ArrayList<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    public ArrayList<Monster> getMonsterList() {
        return monsterList;
    }

    @BeforeEach
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Monster> monsterList = new ArrayList<>();
        try {
            monsterList = mapper.readValue(new URL("https://dl.dropboxusercontent.com/s/iwz112i0bxp2n4a/5e-SRD-Monsters.json"), new TypeReference<List<Monster>>() {
            });
            setMonsterList(monsterList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("testing getMonster method")
    void testGetMonster() {
        Monster monster = MonsterManager.getMonster("Imp");
        assert monster != null;
    }
}