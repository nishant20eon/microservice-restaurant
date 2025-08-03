package com.eon.order.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class Sequence {

    @Id
    private String id; // MUST be String

    private int sequence;

    public Sequence() {}

    public Sequence(String id, int sequence) {
        this.id = id;
        this.sequence = sequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "id='" + id + '\'' +
                ", sequence=" + sequence +
                '}';
    }
}

