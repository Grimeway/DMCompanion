package domain.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;


public class UserManager {
    private static ArrayList<User> allUsers = new ArrayList<>();
    private static SaveFile saveFile = new SaveFile();
    private static UserManager userManager = new UserManager();

    public static UserManager getUserManager() {
        return userManager;
    }

    public static void setUserManager(UserManager userManager) {
        UserManager.userManager = userManager;
    }

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

    public void writeToFile() {
        ObjectMapper mapper = new ObjectMapper();


        try {
            mapper.writeValue(new File("C:\\Users\\mkwan\\Documents\\School\\HBO ICT\\Vakken\\IPASS\\DMCompanion\\src\\main\\java\\domain\\model\\Logins.json"), allUsers);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
