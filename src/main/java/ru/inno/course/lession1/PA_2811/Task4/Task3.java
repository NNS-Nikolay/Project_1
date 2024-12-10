package ru.inno.course.lession1.PA_2811.Task4;

public class Task3 {

    public static void main(String[] args) {
        int[] numbers = {1, 5, 7, 3, 2, 0, 4, 9, 6};

        try {
            int secondLargest = findSecondLargest(numbers);
            System.out.println("Второй по величине элемент: " + secondLargest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int findSecondLargest(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Массив должен содержать как минимум два элемента.");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Нет второго максимального элемента (все элементы одинаковые).");
        }
        return secondLargest;
    }
}

