package ru.inno.course.lession1.HomeWork2.Tho;

import org.w3c.dom.ls.LSOutput;

public class Task2 {
    public static void main(String[] args) {
        Flat flat = new Flat("3", 19, "2");
        Room room = new Room("2", 3.2);
        System.out.println("Количество жилых комнат " + flat.bathroom);
        System.out.println("Количество Ванных комнат " + flat.bathroom);
        System.out.println("Размер кухни " + flat.kitchen + "m2");
        System.out.println("Высота потолка " + room.height);
        System.out.println("Количество окон в комнате " + room.window);
    }
}
