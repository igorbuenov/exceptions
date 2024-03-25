package section15.aula173.application;

import section15.aula173.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = input.nextInt();
        System.out.print("Check-In date (dd/MM/yyyy): ");
        Date checkIn = dateFormat.parse(input.next());
        System.out.print("Check-Out date (dd/MM/yyyy): ");
        Date checkOut = dateFormat.parse(input.next());

        if(!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-In date (dd/MM/yyyy): ");
            checkIn = dateFormat.parse(input.next());
            System.out.print("Check-Out date (dd/MM/yyyy): ");
            checkOut = dateFormat.parse(input.next());

            Date now = new Date();
            if(checkIn.before(now ) || checkIn.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future.");
            } else if(!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }



        }


    }
}
