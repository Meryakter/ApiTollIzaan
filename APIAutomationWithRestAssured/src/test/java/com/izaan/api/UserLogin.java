package com.izaan.api;

import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;

public class UserLogin {
    public static Response userLoginApi() {
        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/cognito-login");

        String requestBody = Base.generatePayLoadString("UserLogin.json");

        Response responseBody = Base.POSTRequest(url, requestBody, bearerToken);

        return responseBody;
    }

    public static Response userLoginErrorApiNegativeTest() {
        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/cognito-login");

        String requestBody = Base.generatePayLoadString("userLoginErrorNegativeTest.json");

        Response responseBody = Base.POSTRequest(url, requestBody, bearerToken);

        return responseBody;

    }
}
