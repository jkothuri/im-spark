package com.imanage.spark.app;

import com.imanage.spark.api.Hello;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args){
        port(8080);
        init();
        awaitInitialization();
        Hello hello=new Hello();
        hello.hello();
    }
}
