package ru.api.cucumber.stepdef;

import io.cucumber.java.en.And;
import ru.api.cucumber.requests.Requests;

public class StepDefenition {
    @And("сделать фиксированный get запрос к апи по пути \"(.*)\"$")
    public void getRequest(String path){
        Requests request = new Requests();
        request.getRequest(path);
    }

    @And("сделать фиксированный post запрос к апи по пути \"(.*)\"$")
    public void postRequest(String path){
        Requests request = new Requests();
        request.postRequest(path);
    }

    @And("сделать фиксированный put запрос к апи по пути \"(.*)\"$")
    public void putRequest(String path){
        Requests request = new Requests();
        request.putRequest(path);
    }

    @And("сделать фиксированный delete запрос к апи по пути \"(.*)\"$")
    public void deleteRequest(String path){
        Requests request = new Requests();
        request.deleteRequest(path);
    }
}
