package domain.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.ArrayList;

public class UserManager {
    private static ArrayList<User> allUsers = new ArrayList<>();
    private static SaveFile saveFile = new SaveFile();

    public static SaveFile getSaveFile() {
        return saveFile;
    }

    public static void setSaveFile(SaveFile saveFile) {
        UserManager.saveFile = saveFile;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static void setAllUsers(ArrayList<User> allUsers) {
        UserManager.allUsers = allUsers;
    }

    public static boolean checkUser(String login, String password) {
        for (User user : allUsers) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void writeToFile() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(Paths.get("src/main/java/domain/listeners/Logins.json").toFile(), allUsers);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
