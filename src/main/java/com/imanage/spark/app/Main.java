package com.imanage.spark.app;

import com.imanage.spark.api.SparkAPIServer;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args){
        port(8080);
        init();
        awaitInitialization();
        SparkAPIServer sparkAPIServer=new SparkAPIServer();
        sparkAPIServer.api();
    }
}
