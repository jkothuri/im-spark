package com.imanage.spark.api;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class HelloTest {

    @Tag("DEV")
    @Test
    void testProcessHello(){
        Hello hello=new Hello();
        assertAll(
                ()->assertTrue(true),
                ()->assertNotNull(hello),
                ()->assertEquals("Hello !!!",hello.processHello(null)),
                ()->assertEquals("Good Morning Chicago",hello.processHello("Chicago"))
        );
    }

}

