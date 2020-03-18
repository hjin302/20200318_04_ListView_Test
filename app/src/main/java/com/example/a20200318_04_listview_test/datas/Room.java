package com.example.a20200318_04_listview_test.datas;

import java.io.Serializable;

public class Room implements Serializable {
    private int price;
    private String adress;
    private int floor;
    String description;

    public String getFormattedPrive(){
//        상황에 따라 ?억 ?천, ?천인지로
//        나눠서 리턴을 해줌
        if(this.price >= 10000){
            int uk = this.price / 10000;
            int thousand = this.getPrice() % 10000;

            return String.format("%d억 %,d", uk, thousand);
        }else{
            return String.format("%,d", this.price);
        }
    }

    public Room(int price, String adress, int floor, String description) {
        this.price = price;
        this.adress = adress;
        this.floor = floor;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
