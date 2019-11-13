package com.imanage.spark.api;

import com.despegar.http.client.GetMethod;
import com.despegar.http.client.HttpClientException;
import com.despegar.http.client.HttpResponse;
import com.despegar.http.client.PostMethod;
import com.despegar.sparkjava.test.SparkServer;
import org.junit.ClassRule;
import org.junit.Test;
import spark.servlet.SparkApplication;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SparkAPIServerIT {


    public static class SparkAPIServerTestApp implements SparkApplication{
        @Override
        public void init(){
            new SparkAPIServer().api();
        }
    }

    @ClassRule
    public static SparkServer<SparkAPIServerTestApp> testServer = new SparkServer<>(SparkAPIServerTestApp.class);

    @Test
    public void serverRespondsSuccessfully() throws HttpClientException {
        GetMethod request = testServer.get("/", false);
        HttpResponse httpResponse = testServer.execute(request);
        assertAll(
                () -> assertEquals(200, httpResponse.code())
        );
    }

    @Test
    public void testHello() throws HttpClientException {
        GetMethod request = testServer.get("/", false);
        HttpResponse httpResponse = testServer.execute(request);
        assertAll(
                () -> assertEquals(200, httpResponse.code()),
                () -> assertEquals(("Hello !!!").getBytes().length,httpResponse.body().length)
        );
    }

    @Test
    public void testHelloWithNoParam() throws HttpClientException {
        GetMethod request = testServer.get("/hello/", false);
        HttpResponse httpResponse = testServer.execute(request);
        assertAll(
                () -> assertEquals(404, httpResponse.code())
        );
    }

    @Test
    public void testHelloWithParam() throws HttpClientException {
        String requestParam="Chicago";
        GetMethod request = testServer.get("/hello/"+requestParam, false);
        HttpResponse httpResponse = testServer.execute(request);
        assertAll(
                () -> assertEquals(200, httpResponse.code()),
                () -> assertEquals(("Good Morning "+requestParam).getBytes().length,httpResponse.body().length)
        );

    }

    @Test
    public void testPostAMessage() throws HttpClientException {
        String requestBody="{\"text\":\"this is the text of the message\",\"from\":\"dave\",\"to\":\"jagadeesh\"}";
        String responseBody="{\"id\":1,\"text\":\"this is the text of the message\",\"from\":\"dave\",\"to\":\"jagadeesh\"}";
        PostMethod request=testServer.post("/messages",requestBody,false);
        HttpResponse httpResponse = testServer.execute(request);
        assertAll(
                () -> assertEquals(200, httpResponse.code()),
                () -> assertEquals(responseBody.getBytes().length,httpResponse.body().length)
        );
        testGetExistingMessage();
    }


    public void testGetExistingMessage() throws HttpClientException {
        String requestParam="1";
        String responseBody="{\"id\":1,\"text\":\"this is the text of the message\",\"from\":\"dave\",\"to\":\"jagadeesh\"}";
        GetMethod request = testServer.get("/messages/"+requestParam, false);
        HttpResponse httpResponse = testServer.execute(request);
        assertAll(
                () -> assertEquals(200, httpResponse.code()),
                () -> assertEquals(responseBody.getBytes().length,httpResponse.body().length)
        );
    }

    @Test
    public void testGetMessageThatDoesNotExist() throws HttpClientException {
        String requestParam="10";
        GetMethod request = testServer.get("/messages/"+requestParam, false);
        HttpResponse httpResponse = testServer.execute(request);
        assertAll(
                () -> assertEquals(404, httpResponse.code()),
                () -> assertEquals("Message not found".getBytes().length,httpResponse.body().length)
        );
    }


}
