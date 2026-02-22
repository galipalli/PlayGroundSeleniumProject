package Utilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    private JsonObject jsonObject;

    public JsonDataReader(String jsonFilePath) {
        try (FileReader reader = new FileReader(jsonFilePath)) {
            JsonElement element = JsonParser.parseReader(reader);
            if (element != null && element.isJsonObject()) {
                jsonObject = element.getAsJsonObject();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername(int index) {
        JsonArray users = jsonObject.getAsJsonArray("userslogin");
        return users.get(index).getAsJsonObject().get("username").getAsString();
    }

    public String getPassword(int index) {
        JsonArray users = jsonObject.getAsJsonArray("userslogin");
        return users.get(index).getAsJsonObject().get("password").getAsString();
    }
}
