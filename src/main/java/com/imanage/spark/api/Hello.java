package com.imanage.spark.api;

import static spark.Spark.*;

public class Hello {

    public void Hello(){

    }
    public void hello(){
        get("/", (req,resp) -> processHello(null));
        get("hello/:name" ,(req,resp) -> processHello(req.params(":name")));
    }

    public String processHello(String paramValue){
        return null==paramValue?"Hello !!!":"Good Morning "+paramValue;
    }
}
