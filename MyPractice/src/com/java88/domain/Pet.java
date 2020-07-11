package com.java88.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Pet {
    private String name;
    private Integer level;
    private Integer damage;
    private Integer maxHealth;
    private Integer nowHealth;
    Pet(){

    }
    Pet(String name,Integer level)
    {
        this.name = name;
        this.level = level;
    }
}
