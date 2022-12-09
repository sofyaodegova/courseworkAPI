package testSteps;

import API.AccessSystem;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import io.restassured.response.Response;
import org.junit.Assert;

public class TestSteps {

    public static Response response;

    @Дано("^'(.+)' осуществляется по ключу: (\\d+) в комнату (\\d+)$")
    public void accessRoomCondition(String entrance, Integer keyId, Integer roomId) {
        response = AccessSystem.entryExitAccess(entrance, keyId, roomId);
        System.out.println(response.asString());
    }

    @Дано("^Информация о комнатах$")
    public void getRoomsInfo() {
        response = AccessSystem.roomInfo();
        System.out.println(response.asString());
    }

    @Тогда("^Ожидается статус-код (\\d+)$")
    public void checkStatusCode(Integer statusCode) {
        Integer responseStatusCode = response.getStatusCode();
        Assert.assertEquals(responseStatusCode, statusCode);
    }

    @Тогда("^Информация о пользователях start: (\\d) end: (\\d)$")
    public void getUsersInfo(Integer startWorking, Integer endWorking) {
        response = AccessSystem.usersInfo(startWorking, endWorking);
        System.out.println(response.asString());
    }
}