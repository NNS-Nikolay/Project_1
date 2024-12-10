package ru.inno.course.lession1.HomeWork3;

public class TopPlayers {
    public static void main(String[] args) {
        Player[] players = {
                new Player("Cristiano Ronaldo"),
                new Player("Lionel Messi"),
                new Player("Luis Suarez"),
                new Player("Antoine Griezmann"),
                new Player("Neymar"),
                new Player("Gareth Bale"),
                new Player("Robert Lewandowski"),
                new Player("Kevin de Bruynen"),
                new Player("Sergio Aguero"),
                new Player("Manuel Neuer")

        };
        System.out.println("Тройка призеров");

        for (int player = 0; player < 3; player = player + 1)
            System.out.println(players[player].names);

    }

}
