package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException{
        Locale.setDefault(Locale.US);
        var scanner = new Scanner(System.in);
        var dateformat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.printf("Room number: ");
        int number = scanner.nextInt();
        System.out.printf("Check-in date (dd/MM/yyyy): ");
        Date checkIn = dateformat.parse(scanner.next());
        System.out.printf("Check-out date (dd/MM/yyyy): ");
        Date checkOut = dateformat.parse(scanner.next());

        if(!checkOut.after(checkIn)){
            System.out.printf("Error in reservation! Check-out date must be after check in data");
        } else {
            var reservation = new Reservation(number, checkIn, checkOut);
            System.out.printf("Reservation: " + reservation);

            System.out.println();
            System.out.println();

            System.out.printf("Enter the check-in to update reservations");
            System.out.printf("Check-in date (dd/MM/yyyy): ");
            checkIn = dateformat.parse(scanner.next());
            System.out.printf("Check-out date (dd/MM/yyyy): ");
            checkOut = dateformat.parse(scanner.next());

            Date now = new Date();

            if (checkIn.before(now) || checkOut.before(now)){
                System.out.printf("Error in reservation: Reservation dates for updates must be future");
            } else if (!checkOut.after(checkIn)){
                System.out.printf("Error in reservation! Check-out date must be after check in data");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.printf("Reservation: " + reservation);
            }
        }

        scanner.close();
    }
}
