package test;

import lombok.ToString;

import java.util.HashMap;
@ToString
public class House {
    //面积 价格 类型
    private Integer id;
    private Integer type;

    private String name;
    private String owner;

    private Double price;
    private Double area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if(price>=300000000.0){
            this.price = price;
        }else{
            System.out.println("你输入的不是真正的房价");
        }

    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        if(area >= 20.0){
            this.area = area;
        }else{
            System.out.println("你输入的面积有毒");
        }

    }

    public static void main(String[] args) {
        House house = new House();
        house.setId(1);
        house.setName("汤臣一品");
        house.setArea(1084.8);
        house.setOwner("老王");
        house.setPrice(30000000.0);
        house.setPrice(420000000.0);
        house.setType(3);
        System.out.println(house);


    }
}
