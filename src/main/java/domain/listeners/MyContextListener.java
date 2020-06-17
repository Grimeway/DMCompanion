package domain.listeners;

import domain.model.NewPlayer;
import domain.model.SaveFile;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SaveFile.getSaveFile().getPlayerList().add(new NewPlayer("grimeway", "Human", "Paladin", 15, 18, 14, 1));
    }

}
