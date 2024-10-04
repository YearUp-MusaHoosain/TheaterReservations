package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class TheaterReservations {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Input
        String fullName = promptForString("Please enter your name: ");
        String dateOfTheShow = promptForDate("What date will you be coming (MM/dd/yyyy): ");
        int numberOfTickets = promptForInt("How many tickets would you like? ");


        //OUTPUT
        String confirmationMessage = reservationInfo(fullName, numberOfTickets, dateOfTheShow);
        System.out.println(confirmationMessage);

        //Display confirmation message
        //# ticket(s) reserved for (date) under (LastName, FirstName)

    }

    public static String reservationInfo(String fullName, int numberOfTickets, String dateOfTheShow) {
        String[] nameParts = fullName.split(Pattern.quote(" "));

        String firstName = nameParts[0];
        String lastName = nameParts[1];

        String confirmationMessage = numberOfTickets == 1 ?
                """
                %d ticket reserved for %s under %s, %s
                """ .formatted(numberOfTickets, dateOfTheShow, lastName, firstName) :
                """
                %d tickets reserved for %s under %s, %s
                """ .formatted(numberOfTickets, dateOfTheShow, lastName, firstName);
        return confirmationMessage;
    }

    public static String promptForString(String prompt){
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public static int promptForInt(String prompt){
        System.out.print(prompt);
        return sc.nextInt();
    }

    public static String promptForDate(String prompt){
        System.out.print(prompt);
        String userInput = sc.nextLine().trim();
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(userInput, dtFormatter);
        System.out.println(date);
        return date.toString();
    }
}
