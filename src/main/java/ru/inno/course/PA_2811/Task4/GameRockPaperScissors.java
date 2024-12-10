package ru.inno.course.PA_2811.Task4;

import java.util.Random;
import java.util.Scanner;

public class GameRockPaperScissors {
    public static class RockPaperScissors {
        private static final int ROUNDS = 5;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            int userScore = 0;
            int computerScore = 0;
            for (int round = 1; round <= ROUNDS; round++) {
                System.out.println("Раунд " + round + ":");
                System.out.print("Введите ваш выбор (К - камень, Н - ножницы, Б - бумага): ");
                String userChoice = scanner.nextLine().toUpperCase();
                int computerChoiceNum = random.nextInt(3);
                //////////
                String computerChoice = switch (computerChoiceNum) {
                    case 0 -> "К";
                    case 1 -> "Н";
                    default -> "Б";
                };

                System.out.println("Компьютер выбрал: " + computerChoice);
                if (userChoice.equals(computerChoice)) {
                    System.out.println("Ничья! Оба получает 0 очков.");
                } else if (userChoice.equals("К")) {
                    if (computerChoice.equals("Н")) {
                        userScore += 1;
                        System.out.println("Вы выиграли! Получаете 1 очко.");
                    } else {
                        computerScore += 5;
                        System.out.println("Вы проиграли! Компьютер получает 5 очков.");
                    }
                } else if (userChoice.equals("Н")) {
                    if (computerChoice.equals("Б")) {
                        userScore += 2;
                        System.out.println("Вы выиграли! Получаете 2 очка.");
                    } else {
                        computerScore += 1;
                        System.out.println("Вы проиграли! Компьютер получает 1 очко.");
                    }
                } else if (userChoice.equals("Б")) {
                    if (computerChoice.equals("К")) {
                        userScore += 5;
                        System.out.println("Вы выиграли! Получаете 5 очков.");
                    } else {
                        computerScore += 2;
                        System.out.println("Вы проиграли! Компьютер получает 2 очка.");
                    }
                } else {
                    System.out.println("Недопустимый выбор. Пожалуйста, выберите К, Н или Б.");
                    round--;
                }
                System.out.println("Текущий счет - Вы: " + userScore + " Компьютер: " + computerScore);
                System.out.println();
            }

            System.out.println("Игра окончена!");
            System.out.println("Ваш финальный счет: " + userScore);
            System.out.println("Счет компьютера: " + computerScore);
            if (userScore > computerScore) {
                System.out.println("Вы выиграли игру!");
            } else if (userScore < computerScore) {
                System.out.println("Компьютер выиграл игру!");
            } else {
                System.out.println("Это ничья!");
            }
            scanner.close();
        }
    }
}
