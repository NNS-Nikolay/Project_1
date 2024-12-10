package ru.inno.course.PA_2811.Task1;

import java.util.Scanner;

public class Length {
    public static void main(String[] args) {
        int space = 12;
        int numberSpace = 3;
        int threeLetter = 62;
        int numberLetters = 15;

        int lengthForLetters = (numberLetters / 3) * threeLetter;
        int lengthForSpaces = numberSpace * space;
        int requiredLength = lengthForLetters + lengthForSpaces;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите максимальную длину забора (в см)");
        int fenceLength = scanner.nextInt();

        if (fenceLength >= requiredLength) {
            System.out.println("Поздравляем, надпись на заборе поместится!");
        } else {
            System.out.println("Не хватает длины забора, сократите текст");
        }

    }
}
