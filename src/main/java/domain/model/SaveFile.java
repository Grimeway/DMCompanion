package domain.model;

import java.util.ArrayList;

public class SaveFile {
    private ArrayList<NewPlayer> playerList = new ArrayList<>();
    private static SaveFile saveFile = new SaveFile();

    public ArrayList<NewPlayer> getPlayerList() {
        return playerList;
    }

    public static SaveFile getSaveFile() {
        return saveFile;
    }

}
