package ru.inno.course.PA_2811.Task2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class Cactus {
    public static void main(String[] args) {

        ArrayList<Number> MonthsOfWinter = new ArrayList<>();
        MonthsOfWinter.add(12);
        MonthsOfWinter.add(1);
        MonthsOfWinter.add(2);

        ArrayList<Number> MonthsOfAutumnSpring = new ArrayList<>();
        MonthsOfAutumnSpring.add(11);
        MonthsOfAutumnSpring.add(10);
        MonthsOfAutumnSpring.add(9);
        MonthsOfAutumnSpring.add(5);
        MonthsOfAutumnSpring.add(4);
        MonthsOfAutumnSpring.add(3);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату последнего полива в формате гггг-мм-дд: ");

        String UserDateString = scanner.nextLine();

        try {
            LocalDate WaterDate = LocalDate.parse(UserDateString);

            LocalDate DateNow = LocalDate.now();
            int NumberOfMonth = DateNow.getMonthValue();
            long DAYSbetween = ChronoUnit.DAYS.between(WaterDate, DateNow);

            if (DAYSbetween > 31) {
                System.out.println("Ваш кактус издох, можете не поливать ;-(");
            } else {

                if (MonthsOfWinter.contains(NumberOfMonth)) {

                    LocalDate NewWaterDate = WaterDate.plusMonths(1);
                    System.out.println("Сейчас зима, поливаем раз в месяц. Новая дата полива: " + NewWaterDate);

                } else if (MonthsOfAutumnSpring.contains(NumberOfMonth)) {

                    LocalDate NewWaterDate = WaterDate.plusDays(7);
                    System.out.println("Сейчас весна/осень, поливаем раз в неделю. Новая дата полива: " + NewWaterDate);

                } else {

                    int HumiditySensor = new Random().nextInt(100);
                    if (HumiditySensor < 30) {
                        LocalDate NewWaterDate = WaterDate.plusDays(2);
                        System.out.println("Сейчас лето, поливаем раз в два дня. Влажность: " + HumiditySensor +
                                "%. Новая дата полива: " + NewWaterDate);
                    } else {
                        System.out.println("Катус не нуждается в поливе, сейчас лето и влажность: " + HumiditySensor + "%");
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Введена некорректная дата");
        }


    }
}