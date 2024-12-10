package ru.inno.course.lession1.HomeWork3;

public class ListFilm {
    public static void main(String[] args) {
        Movie[] films = {
                new Movie("Властелин колец: Братство Кольца ", 9.1, "fantasu", "USA", 2001),
                new Movie("Властелин колец: Две крепости ", 9.0, "fantasu", "USA", 2002),
                new Movie("Властелин колец: Возвращение короля ", 9.5, "fantasu", "USA", 2003)
        };

        for (int movie = 0; movie < 3; movie = movie + 1) {
            System.out.println(films[movie].year + " " + films[movie].name + films[movie].genre + " " + films[movie].rating);
        }
        int i = 0;
    }
}
