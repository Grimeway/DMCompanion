package domain.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveFile {
    private ArrayList<Player> playerList = new ArrayList<>();
    private static SaveFile saveFile = new SaveFile();

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public static SaveFile getSaveFile() {
        return saveFile;
    }

    public static void setSaveFile(SaveFile saveFile) {
        SaveFile.saveFile = saveFile;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public boolean editPlayer(Player player) {
        System.out.println(player.getPlayerName());
        for (Player p : playerList) {
            if (p.getPlayerName().equals(player.getPlayerName())) {
                p.setPlayerName(player.getPlayerName());
                p.setPlayerRace(player.getPlayerRace());
                p.setPlayerClass(player.getPlayerClass());
                p.setPlayerHealth(player.getPlayerHealth());
                p.setPlayerAC(player.getPlayerAC());
                p.setPlayerPP(player.getPlayerPP());
                p.setPlayerInitiative(player.getPlayerInitiative());

                writeToFile();
                return true;
            }
        }
        return false;
    }

    public void writeToFile() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("C:\\Users\\Michel\\Documents\\HBO ICT\\Vakken\\IPASS\\DmCompanion\\src\\main\\java\\domain\\model\\players.json"), playerList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public boolean removePlayer(String playerName) {
        ObjectMapper mapper = new ObjectMapper();

        if (playerList.removeIf(player -> player.getPlayerName().equals(playerName))) {
            try {
                mapper.writeValue(new File("C:\\Users\\Michel\\Documents\\HBO ICT\\Vakken\\IPASS\\DmCompanion\\src\\main\\java\\domain\\model\\players.json"), playerList);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;

    }

}
