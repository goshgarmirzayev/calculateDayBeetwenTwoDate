/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author Goshgar
 */
public class Date {

    public static final String ANSI_RED = "\u001B[31m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        try {
            findDay();
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Invalid Input... Please reenter true information...");
            Thread.sleep(3000);
            for (int i = 0; i < 100; i++) {
                System.out.println("\b\b\b\b\b");
            }
            findDay();
        }
    }

    public static void findDay() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hi! Please enter your name: ");
        String name = sc.nextLine();

        int year, day, months;
        System.out.println("Enter Start Date");
        Thread.sleep(1000);
        System.out.print("Enter year: ");
        year = sc.nextInt();
        System.out.print("Enter Month: ");
        months = sc.nextInt();
        Thread.sleep(1000);

        while (months > 12 || months < 1) {
            System.out.println(ANSI_RED + "Please true information and try again!");
            Thread.sleep(3000);
            System.out.print("\b\b\b\b\b");
            System.out.print("Enter Month: ");
            months = sc.nextInt();
        }
        System.out.print("Enter day: ");
        day = sc.nextInt();
        while (day < 0 || day > 31) {
            System.out.println("Please true information and try again!");
            System.out.print("Enter day: ");
            day = sc.nextInt();
        }
        System.out.println("You were Entered date:" + year + "/" + months + "/" + day);
        LocalDate dateBefore = LocalDate.of(year, months, day);
        int newYear, newMoths, newDay;
        System.out.println("Enter End of Date");
        Thread.sleep(1000);
        System.out.print("Enter year: ");
        newYear = sc.nextInt();
        System.out.print("Enter Month: ");
        newMoths = sc.nextInt();
        while (newMoths > 12 || newMoths < 1) {
            System.out.println("Please true information and try again!");
            System.out.print("Enter Month: ");
            newMoths = sc.nextInt();
        }
        System.out.print("Enter day: ");
        newDay = sc.nextInt();
        while (newDay < 0 || newDay > 31) {
            System.out.println("Please true information and try again!");
            System.out.print("Enter day: ");
            newDay = sc.nextInt();
        }
        Thread.sleep(1000);
        System.out.println("You were Entered date:" + newYear + "/" + newMoths + "/" + newDay);
        LocalDate dateAfter = LocalDate.of(newYear, newMoths, newDay);
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        if (noOfDaysBetween < 0) {
            System.out.println(name + "Daxil etdiyiniz tarixlər arası vaxt " + noOfDaysBetween * (-1) + " gündür");
        } else {
            System.out.println(name + " Daxil etdiyiniz tarixlər arası vaxt " + noOfDaysBetween + " gündür");
        }
    }
}
