package com.izaan.api;

import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;

public class CreateUserRequest {

    public static Response createUserAPI(){


        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/cognito-create-user");

        String requestBody = Base.generatePayLoadString("CreateUser.json");

        Response responseBody = Base.POSTRequest(url, requestBody, bearerToken);

        return responseBody;

    }
   public static Response createUserAPINegativeTesting() {


       String bearerToken = "Bearer " + GetToken.getToken();

       String url = URL.getEndPoint("/cognito-create-user");

       String requestBody = Base.generatePayLoadString("CreateUserNegativeTest.json");

       Response responseBody = Base.POSTRequest(url, requestBody, bearerToken);

       return responseBody;

   }}