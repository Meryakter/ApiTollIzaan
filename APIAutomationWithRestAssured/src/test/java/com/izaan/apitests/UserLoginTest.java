package com.izaan.apitests;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.CreateUserRequest;

import com.izaan.api.UserLogin;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ReportManager;
import utility.TestUtils;


import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class UserLoginTest {
    static ExtentReports extent;
    private static ExtentTest testLog;

    @Test
    public void validateUserLogin() {
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate user login test");
        Response response = UserLogin.userLoginApi();

        BaseAssertion.verifyStatusCode(response, 200);

        BaseAssertion.verifySpecificMessage(response, "message", "Log in successfully!");

        extent.flush();

    }


    @Test
    public void validateUserLoginWithWrongPassword() {
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate user login test");
        Response response = UserLogin.userLoginErrorApiNegativeTest();
        BaseAssertion.verifyStatusCode(response, 200);
        BaseAssertion.verifySpecificMessage(response, "statusCode", "400");
        BaseAssertion.verifySpecificMessage(response, "message", "Incorrect username or password.");
        extent.flush();

    }
}



