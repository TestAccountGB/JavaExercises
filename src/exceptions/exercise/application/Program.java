package exceptions.exercise.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import exceptions.exercise.entities.Reservation;
import exceptions.exercise.exceptions.CheckoutException;
import exceptions.exercise.exceptions.OlderDateException;

public class Program {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar checkinDate = Calendar.getInstance();
		Calendar checkoutDate = Calendar.getInstance();
		Calendar updatedCheckinDate = Calendar.getInstance();
		Calendar updatedCheckoutDate = Calendar.getInstance();
		
		try {
			
			System.out.print("Room Number: ");
			int roomNumber = scan.nextInt();

			System.out.print("Check-in date (dd/MM/yyyy): ");
			String checkin = scan.next();
			checkinDate.setTime(format.parse(checkin));

			System.out.print("Check-out date (dd/MM/yyyy): ");
			String checkout = scan.next();
			checkoutDate.setTime(format.parse(checkout));
			
			if(checkinDate.after(checkoutDate)) {
				throw new CheckoutException();
			}
			
			Reservation reservation = new Reservation(roomNumber, checkinDate, checkoutDate);
			
			System.out.println(reservation);
			
			System.out.println("\nEnter data to update the reservation:");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = scan.next();
			updatedCheckinDate.setTime(format.parse(checkin));

			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = scan.next();
			updatedCheckoutDate.setTime(format.parse(checkout));
			
			reservation.updateDates(updatedCheckinDate, updatedCheckoutDate);
			System.out.println(reservation);
			
			
		} catch (CheckoutException | OlderDateException | ParseException e) {
			System.err.println(e.getMessage());
			
		} finally {
			scan.close();
		}
		
	}
}
