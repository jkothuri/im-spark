package com.imanage.spark.data;

import java.util.Objects;

public class Message {
    int id;
    String text;
    String from;
    String to;

    public Message( String text, String from, String to) {
        //this.id = id;
        this.text = text;
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id &&
                Objects.equals(text, message.text) &&
                Objects.equals(from, message.from) &&
                Objects.equals(to, message.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, from, to);
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
}
