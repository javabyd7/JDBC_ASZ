package pl.sda.jdbc;

import java.sql.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException {
        EmployeeService employeeService = new EmployeeService();

        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("1. DODAJ PRACOWNIKA, 2. WYSWIETL WSZYSTKICH PRACOWNIKÓW, 3. KONIEC");
            String number = scan.nextLine();
            switch (number) {
                case "1":
                    System.out.println("PODAJ ID PRACOWNIKA: ");
                    int employeeNumber = scan.nextInt();
                    System.out.println("PODAJ NAZWISKO: ");
                    String lastName = scan.next();
                    System.out.println("PODAJ IMIE: ");
                    String firstName = scan.next();
                    System.out.println("PODAJ EXTENSION: ");
                    String extension = scan.next();
                    System.out.println("PODAJ EMAIL: ");
                    String email = scan.next();
                    System.out.println("PODAJ STANOWISKO: ");
                    String jobTitle = scan.next();

                    employeeService.addEmployee(employeeNumber, lastName, firstName, extension, email, 1, 1002, jobTitle);
                    break;
                case "2":
                    employeeService.printAllEmployee();
                    break;
                case "3":
                    return;
            }
        }

    }


}
