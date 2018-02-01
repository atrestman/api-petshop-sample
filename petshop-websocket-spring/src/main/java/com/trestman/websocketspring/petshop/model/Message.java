package com.trestman.websocketspring.petshop.model;

import lombok.Data;

@Data
public class Message {

    private String from;
    private String text;
}