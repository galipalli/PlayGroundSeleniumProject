package Utilities;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    private JSONObject jsonObject;

    public JsonDataReader(String jsonFilePath) {
        try (FileReader reader = new FileReader(jsonFilePath)) {
            JSONTokener tokener = new JSONTokener(reader);
            jsonObject = new JSONObject(tokener);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername(int index) {
        JSONArray users = jsonObject.getJSONArray("userslogin");
        return users.getJSONObject(index).getString("username");
    }

    public String getPassword(int index) {
        JSONArray users = jsonObject.getJSONArray("userslogin");
        return users.getJSONObject(index).getString("password");
    }
}
