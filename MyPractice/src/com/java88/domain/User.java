package com.java88.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.aspectj.bridge.IMessage;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter@Setter@ToString
public class User {
    private String userName;
    private String password;
    private String Nickname;

    private Integer level;
    @Max(value = 800,message = "不允许如此多的金钱")
    private Integer money;

    @NotNull
    private Integer maxHealth;
    private Integer nowHealth;
    private Integer strength;
    private Integer agility;
    private Integer intelligence;

    private Weapon weapon;

    private Pet pet;
    private ArrayList<Pet> pets;

    private String[] hobby;
    private ArrayList<String> hobbys;
    User()
    {
        hobbys = new ArrayList<>();
        hobbys.add("足球");
        hobbys.add("篮球");
        hobbys.add("网球");
        pets = new ArrayList<>();
        pets.add(new Pet("狗",11));
        pets.add(new Pet("猫",7));
        pets.add(new Pet("猪",81));
    }




}
