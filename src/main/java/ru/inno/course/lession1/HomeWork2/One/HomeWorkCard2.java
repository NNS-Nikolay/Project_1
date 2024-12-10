package ru.inno.course.lession1.HomeWork2.One;

public class HomeWorkCard2 {

    public static void main(String[] args) {
        Card card = new Card("1126357456875635", "1234");
        System.out.println(card.getNumber());
        System.out.println(card.getNumber("1234"));
    }
}
