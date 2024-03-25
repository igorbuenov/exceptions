package section15.aula173.application;

import section15.aula173.model.entities.Reservation;
import section15.aula173.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {

        Scanner input = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {

            System.out.print("Room number: ");
            int roomNumber = input.nextInt();
            System.out.print("Check-In date (dd/MM/yyyy): ");
            Date checkIn = dateFormat.parse(input.next());
            System.out.print("Check-Out date (dd/MM/yyyy): ");
            Date checkOut = dateFormat.parse(input.next());


            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-In date (dd/MM/yyyy): ");
            checkIn = dateFormat.parse(input.next());
            System.out.print("Check-Out date (dd/MM/yyyy): ");
            checkOut = dateFormat.parse(input.next());

            reservation.updateDates(checkIn, checkOut);


        } catch (ParseException e) {
            System.out.println("Invalid date format!");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }
        finally {
            input.close();
        }


    }
}
