package ru.inno.course.lession1.HomeWork2.Three;

public class Task3 {
    public static void main(String[] args) {
        Item bananas = new Item("bananas","112233b", 100, 1);
        Item pear = new Item("pear","112233p", 110, 1);
        Item tomato = new Item("tomato","112233t", 110, 1);
        Item potato = new Item("potato","11223pt", 110, 1);
        Item grape = new Item("grape","112233g", 110, 1);
        System.out.println(bananas.name + " " + "арт" + bananas.article + " " + bananas.price + "руб " +"за " + bananas.quantity + " кг");
        System.out.println(pear.name + " " + "арт" + pear.article + " " + pear.price + "руб " +"за " + pear.quantity + " кг");
        System.out.println(tomato.name + " " + "арт" + tomato.article + " " + tomato.price + "руб " +"за " + tomato.quantity + " кг");
        System.out.println(potato.name + " " + "арт" + potato.article + " " + potato.price + "руб " +"за " + potato.quantity + " кг");
        System.out.println(grape.name + " " + "арт" + grape.article + " " + grape.price + "руб " +"за " + grape.quantity + " кг");

    }
}
