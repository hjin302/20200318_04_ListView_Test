package com.example.a20200318_04_listview_test.datas;

import java.io.Serializable;

public class Room implements Serializable {

    private int price;
    private String address;
    private int floor;
    private String description;

    public String getFloorToString() {
//        층수를 => 상황에 맞는 String 으로 가공.

        String floorStr = "";
//        층 > 0, 층 == 0, 그외 (층 < 0)

        if (this.floor > 0) {
//            4 => "4층" 으로 가공
            floorStr = String.format("%d층", this.floor);
        }
        else if (this.floor == 0) {
//            0 => "반지하" 로.
            floorStr = "반지하";
        }
        else {
//            -1 => "지하 1층" 으로 가공
            floorStr = String.format("지하 %d층", this.floor*-1);
        }

        return floorStr;
    }

    public String getFormattedPrice() {
//        상황에 따라 ?억 ?천,  ?천인지로.
//        나눠서 리턴을 해줌.

        if (this.price >= 10000) {
            int uk = this.price / 10000;
            int thousand = this.price % 10000;

            return String.format("%d억 %,d만원", uk, thousand);
        }
        else {
            return String.format("%,d만원", this.price);
        }

    }

    public Room(int price, String address, int floor, String description) {
        this.price = price;
        this.address = address;
        this.floor = floor;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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