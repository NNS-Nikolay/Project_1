package ru.inno.course.HomeWork3;

public class Movie {
    public Movie(String name, double rating, String genre, String country, int hasOscar) {
        this.name = name;
        this.rating = rating;
        this.genre = genre;
        this.country = country;
        this.year = hasOscar;
    }

    String name;
    double rating;
    String genre;
    String country;
    int year;
}
