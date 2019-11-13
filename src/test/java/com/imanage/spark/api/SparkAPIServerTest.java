package com.imanage.spark.api;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class SparkAPIServerTest {

    
    @Tag("DEV")
    @Test
    void testProcessHello(){
        SparkAPIServer hello=new SparkAPIServer();
        assertAll(
                ()->assertTrue(true),
                ()->assertNotNull(hello),
                ()->assertEquals("Hello !!!",hello.processHello(null)),
                ()->assertEquals("Good Morning Chicago",hello.processHello("Chicago"))
        );
    }

    @Tag("DEV")
    @Test
    void testProcessIncomingMessage(){
        SparkAPIServer sparkAPIServer=new SparkAPIServer();
        String requestBody="{\"text\":\"this is the text of the message\",\"from\":\"dave\",\"to\":\"jagadeesh\"}";
        String responseBody="{\"id\":1,\"text\":\"this is the text of the message\",\"from\":\"dave\",\"to\":\"jagadeesh\"}";
        assertAll(
                ()->assertTrue(true),
                ()->assertNotNull(sparkAPIServer),
                ()->assertEquals(responseBody,sparkAPIServer.processIncomingMessage(requestBody))
        );
    }
}

