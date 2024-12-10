package ru.inno.course.lession1.Lesson3;

public class LessonAray {

    public static void main(String[] args) {

        double mark0 = 0.65; //0
        double mark1 = 0.4;  //3
        double mark2 = 0.6;  //4
        double mark3 = 0.8;  //5
        double mark4 = 0.9;
        double mark5 = 1;
        double mark6 = 0.7;
        double mark7 = 0.3;
        double mark8 = 0.2;
        double mark9 = 0.1;
//        System.out.println(mark0);
//        System.out.println(mark1);
//        System.out.println(mark2);
//        System.out.println(mark3);
//
        double[] marks = new double[10];
        marks[0] = 0.65;
        marks[1] = 0.4;
        marks[2] = 0.6;
        marks[3] = 0.8;
        marks[4] = 0.9;
        marks[5] = 1;
        marks[6] = 0.9;
//        System.out.println(marks[0]);
//        System.out.println(marks[1]);
//        System.out.println(marks[2]);
//        System.out.println(marks[3]);
//        System.out.println(marks[4]);
//        System.out.println(marks[5]);
//        System.out.println(marks[6]);
//        System.out.println(marks[7]);
//        System.out.println(marks[8]);
//        System.out.println(marks[9]);

        String[] fruits = new String[4];
        fruits[1] = "Aple";
        fruits[2] = "Orange";
        fruits[3] = "Pineaple";
        System.out.println(fruits[1] + " " + fruits[2] + " " + fruits[3]);


        String[] fruits2 = new String[]{"Aple", "Orange", "Pineaple"};

        String[] fruits3 = {"Aple", "Orange", "Pineaple"};

    }
}
