package com.silence;

import com.silence.di.Container;
import com.silence.model.SuggestionsResponse;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1 - Найти организацию по названию");
            System.out.println("2 - Завершить");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Введите часть названия для поиска:");
                    run(scanner.nextLine());
                    break;
                case 2:
                    quit = true;
                    break;
                default:
                    System.out.println("Некорректный пункт меню, попробуйте еще раз");
            }
        } while (!quit);
        scanner.close();
    }

    public static void run(String query) {
        Container instance = Container.getInstance();
        SuggestionsResponse companiesSuggestions = instance.getCompanyService().findCompaniesSuggestions(query);
        File resultFile = instance.getWriterService().write("output.json", companiesSuggestions);
        System.out.println("Результат записан в файл по адресу: " + resultFile.getAbsolutePath());
    }
}
