package domain.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JsonMappingException, JsonParseException {
        Monster newMonster = new Monster();
        System.out.println(newMonster);

    }
}
