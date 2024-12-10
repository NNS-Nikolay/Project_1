package ru.inno.course.PA_2811.Task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Cactus {
    private final LocalDate lastWateredDate;

    public Cactus(LocalDate lastWateredDate) {
        this.lastWateredDate = lastWateredDate;
    }

    public LocalDate getNextWateringDate() {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        if (month == 12 || month == 1 || month == 2) {
            return lastWateredDate.plusMonths(1);
        } else if (month <= 5 || month >= 9) {
            return lastWateredDate.plusWeeks(1);
        } else {
            Sensor sensor = new Sensor();
            int humidity = sensor.getHumidity();
            if (humidity < 30) {
                if (lastWateredDate.plusDays(2).isBefore(today) || lastWateredDate.plusDays(2).isEqual(today)) {
                    return today;
                } else {
                    return lastWateredDate.plusDays(2);
                }
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lastWateredDate = LocalDate.parse("01/10/2024", formatter);
        Cactus scheduler = new Cactus(lastWateredDate);
        LocalDate nextWateringDate = scheduler.getNextWateringDate();

        if (nextWateringDate != null) {
            System.out.println("Следующая дата полива кактуса: " + nextWateringDate.format(formatter));
        } else {
            System.out.println("Кактус не нуждается в поливе в данный момент.");
        }
    }
}

class Sensor {
    private final Random random;

    public Sensor() {
        random = new Random();
    }

    public int getHumidity() {
        return random.nextInt(101);
    }
}
