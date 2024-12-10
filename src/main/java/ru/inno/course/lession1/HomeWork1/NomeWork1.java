package ru.inno.course.lession1.HomeWork1;

import javax.lang.model.element.Name;

public class NomeWork1 {
    public static void main(String[] args) {
        //1
        Boolean MyResult;
        String name1 = "Николай";
        MyResult = name1.isEmpty(); //Проверка пустой стоки
        System.out.println("1)" + " " + MyResult);

        //2
        Boolean MyResult2;
        String name2 = " ";
        MyResult2 = name2.isBlank(); //Проверка на наличие символов в строке
        System.out.println("2)" + " " + MyResult2);

        //3
        String name3 = "Николай Назаров";
        name3 = name3.substring(0, 7); //Перенос строки
        System.out.println("3)" + " " + name3);

        //4
        String name4 = "Домашнее задание номер один";
        int value = name4.indexOf("задание"); //.indexOf(String) Ищет целую строку
        System.out.println("4)" + " " + value);

        //5
        String name5 = "Домашнее задание номер один";
        int value1 = name5.lastIndexOf("д", 17); //Индекс в этой строке последнего вхождения указанной подстроки
        System.out.println("5)" + " " + value1);

        //6
        String name6 = "СДелать ВСЕ буквы СТРОЧНЫМИ";
        String resultName6 = name6.toLowerCase(); //Делает все буквы в строке строчными
        System.out.println("6)" + " " + resultName6);

        //7
        String name7 = "Сделать ВСЕ буквы заглавными";
        String resultName7 = name7.toUpperCase(); //Делает все буквы звглавными
        System.out.println("7)" + " " + resultName7);

        //8
        String oldName8 = "обучение";
        String newName8 = oldName8.replace('о', 'О'); //заменяет указанный символ
        System.out.println("8)" + " " + newName8);

        //9
        Boolean MyResult3;
        String name9 = "Николай";
        MyResult3 = name9.startsWith("Н"); //Проверяет начинается ли строка с указанного префикса
        System.out.println("9)" + " " + MyResult3);

        //10
        Boolean MyResult4;
        String name10 = "Николай";
        MyResult4 = name10.endsWith("а"); //Проверяет заканчивается ли строка указанным символом
        System.out.println("10)" + " " + MyResult4);

        //11
        String name11 = "Строка ".repeat(3); //Повторить содержимое строки n количество раз
        System.out.println("11)" + " " + name11);

        //12
        Boolean MyResult5;
        String name12 = "Моего кота зовут Кот";
        MyResult5 = name12.contains("зовут"); //Используется для проверки наличия элемента в строке
        System.out.println("12)" + " " + MyResult5);

        //13
        String name13 = "Присоединение";
        name13 = name13.concat(" новой строки"); //добавляет одну строку в конец к другой строки вместо оператора "+"
        System.out.println("13)" + " " + name13);

        //14
        String name14 = "     Удаление пробелов в начале и в конце строки.   ";
        String name15 = "     Удаление пробелов в начале и в конце строки.   ";
        System.out.println("14)" + " " + name14);
        System.out.println("14)" + " " + name15.trim()); // Удалить пробелы в начале и конце строки

        //15
        String name16 = new String("QA");
        String name17 = new String("QA");
        System.out.println("15)" + " " + name16.equals(name17)); // Сравнение объектов
    }

}