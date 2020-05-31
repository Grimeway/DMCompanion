public class NewPlayer {
    private String PlayerName;
    private String playerRace;
    private String playerClass;
    private int playerHealth;
    private int playerAC;
    private int playerPP;
    private int playerInitiative;

    public NewPlayer(String playerName, String playerRace, String playerClass, int playerHealth, int playerAC, int playerPP, int playerInitiative) {
        PlayerName = playerName;
        this.playerRace = playerRace;
        this.playerClass = playerClass;
        this.playerHealth = playerHealth;
        this.playerAC = playerAC;
        this.playerPP = playerPP;
        this.playerInitiative = playerInitiative;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public String getPlayerRace() {
        return playerRace;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getPlayerAC() {
        return playerAC;
    }

    public int getPlayerPP() {
        return playerPP;
    }

    public int getPlayerInitiative() {
        return playerInitiative;
    }
}
