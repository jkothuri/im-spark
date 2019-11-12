package com.imanage.spark.api;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.imanage.spark.data.Message;

import java.io.StringReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.*;

public class SparkAPIServer {

    AtomicInteger counter=new AtomicInteger(0);
    Map<Integer,Message> messageMap=new TreeMap<>();

    public void api(){
        get("/", (req,resp) -> processHello(null));
        get("hello/:name" ,(req,resp) -> processHello(req.params(":name")));
        post("/messages","application/json",(req,resp) -> processIncomingMessage(req.body()));
        get("/messages/:id","application/json",
                                        (req,resp)->{
                                                    Message message=messageMap.get(Integer.valueOf(req.params("id")));
                                                    if(null==message) {
                                                       halt(404,"Message not found");
                                                    }
                                                    return new Gson().toJson(message);
                                                }
            );
    }

    public String processHello(String paramValue){
        return null==paramValue?"Hello !!!":"Good Morning "+paramValue;
    }

    public String processIncomingMessage(String requestBody){
        JsonReader reader=new JsonReader(new StringReader(requestBody.trim()));
        reader.setLenient(true);
        Message message=new Gson().fromJson(reader,Message.class);
        message.setId(counter.incrementAndGet());
        messageMap.put(message.getId(),message);
        return new Gson().toJson(message);
    }
}
