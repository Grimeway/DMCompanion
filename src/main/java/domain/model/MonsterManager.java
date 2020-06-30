package domain.model;

import javax.json.Json;
import java.util.ArrayList;

public class MonsterManager {
    private static ArrayList<Monster> allMonsters = new ArrayList<>();

    public static ArrayList<Monster> getAllMonsters() {
        return allMonsters;
    }

    public static void setAllMonsters(ArrayList<Monster> allMonsters) {
        MonsterManager.allMonsters = allMonsters;
    }

    public static Monster getMonster(String monsterName) {
        for (Monster monster1 : allMonsters) {
            if (monster1.getName().equals(monsterName)) {
                return monster1;
            }
        }
        return null;
    }

    public static ArrayList<String> getMonsterList() {
        ArrayList<String> allMonsterNames = new ArrayList<>();

        for (Monster monster: allMonsters) {
            allMonsterNames.add(monster.getName());
        }

        return allMonsterNames;
    }

    public static void deleteMonster(String monsterName) {
        allMonsters.removeIf(monster -> monster.equals(monsterName));
    }
}
