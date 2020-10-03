package be.pxl.ja.oefeningen.oefening_3_3;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DaysToBirthDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate birthDate = null;
        boolean correctDate;
        do {
            correctDate = true;

            try {
                System.out.print("Geef uw geboortedatum dd/mm: ");
                String date = scanner.next() + "/" + LocalDate.now().getYear();
                birthDate = LocalDate.parse(date, formatter);
            } catch (DateTimeParseException exception) {
                correctDate = false;
                System.out.println("Foutieve datum, probeer opnieuw.");
                System.out.println();
            }
        } while(!correctDate);

        if (LocalDate.now().isAfter(birthDate)) {
            birthDate = birthDate.plusYears(1);
        }

        long daysToBirthDay = ChronoUnit.DAYS.between(LocalDate.now(), birthDate);
        System.out.println("Nog " + daysToBirthDay +  " dagen voor je verjaardag");

        scanner.close();
    }
}
