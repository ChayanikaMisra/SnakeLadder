package com.example.snakeLadder.models;

import java.util.UUID;

public class Player {
    private String id;
    private String name;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.status="playing";

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

