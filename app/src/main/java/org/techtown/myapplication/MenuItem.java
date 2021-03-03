//메뉴 아이템 클래스

package org.techtown.myapplication;

public class MenuItem {

    String name; //메뉴 이름
    String price; //메뉴 가격

    public MenuItem(String name, String price) { //생성자
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
