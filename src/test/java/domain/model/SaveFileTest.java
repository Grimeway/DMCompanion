package domain.model;

import junit.framework.TestCase;

public class SaveFileTest extends TestCase {
    SaveFile saveFile = new SaveFile();

    public void setUp() throws Exception {

        saveFile.getPlayerList().add(new Player("michel", "human", "paladin", 20, 20, 20, 13));
        super.setUp();
    }



    public void testGetPlayerList() {
        for (Player player : saveFile.getPlayerList()) {
            assertEquals(player.getPlayerName(), "michel");
            assertEquals(player.getPlayerRace(), "human");
            assertEquals(player.getPlayerClass(), "paladin");
            assertEquals(player.getPlayerHealth(), 20);
            assertEquals(player.getPlayerAC(), 20);
            assertEquals(player.getPlayerPP(), 20);
            assertEquals(player.getPlayerInitiative(), 13);
        }
    }

    public void testEditPlayer() {
        Player player1 = new Player("michel", "elf", "rogue", 15, 15, 15, 15);
        saveFile.editPlayer(player1);
        for (Player player : saveFile.getPlayerList()) {
            assertEquals(player.getPlayerName(), "michel");
            assertEquals(player.getPlayerRace(), "elf");
            assertEquals(player.getPlayerClass(), "rogue");
            assertEquals(player.getPlayerHealth(), 15);
            assertEquals(player.getPlayerAC(), 15);
            assertEquals(player.getPlayerPP(), 15);
            assertEquals(player.getPlayerInitiative(), 15);
        }
    }

}