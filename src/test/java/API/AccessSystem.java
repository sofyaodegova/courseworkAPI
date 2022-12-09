package API;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AccessSystem {
    public static String baseUri = "http://localhost:8080";

    public static Response entryExitAccess(String entrance, Integer keyId, Integer roomId) {
        switch (entrance) {
            case ("Вход"):
                entrance = "ENTRANCE";
                break;
            case ("Выход"):
                entrance = "EXIT";
                break;
        }

        Map<String, String> params = new HashMap<>();
        params.put("keyId", keyId.toString());
        params.put("roomId", roomId.toString());
        params.put("entrance", entrance);

        String link = "/check";
        return RestRequests.getRequest(baseUri, params, link);
    }

    public static Response roomInfo() {
        Map<String, String> params = new HashMap<>();
        String link = "/info/rooms";
        return RestRequests.getRequest(baseUri, params, link);
    }

    public static Response usersInfo(Integer startWorking, Integer endWorking) {

        Map<String, String> params = new HashMap<>();
        params.put("start", startWorking.toString());
        params.put("end", endWorking.toString());

        String link = "/info/users";
        return RestRequests.getRequest(baseUri, params, link);
    }
}