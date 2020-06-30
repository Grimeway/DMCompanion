package domain.model;

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


    public void removePlayer(String playerName) {
        playerList.removeIf(player -> player.getPlayerName().equals(playerName));
    }

}
