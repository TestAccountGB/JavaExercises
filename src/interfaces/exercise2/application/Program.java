package interfaces.exercise2.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import interfaces.exercise2.model.entities.CarRental;
import interfaces.exercise2.model.entities.Vehicle;
import interfaces.exercise2.model.services.RentalService;
import interfaces.exercise2.model.services.UsTaxService;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\r\n");
		SimpleDateFormat customDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		System.out.println("Enter rental data");
		System.out.println("Car model: ");
		String carModel = scan.next();
		System.out.println("Pickup (dd/MM/yyyy hh:mm)");
		Calendar start = Calendar.getInstance();
		start.setTime(customDate.parse(scan.next()));
		System.out.println("Return (dd/MM/yyyy hh:mm)");
		Calendar finish = Calendar.getInstance();
		finish.setTime(customDate.parse(scan.next())); 
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.println("Enter price per hour");
		double pricePerHour = scan.nextDouble();
		System.out.println("Enter price per day");
		double pricePerDay = scan.nextDouble();
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new UsTaxService());
		rentalService.processInvoice(carRental);
		//Esse metodo calcula a taxa e coloca dentre do carRental que foi passado como parametro
		
		System.out.println("Invoice:");
		System.out.println("Basic Payment: " + String.format("%.2f",  carRental.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f",  carRental.getInvoice().getTax()));
		System.out.println("Total Payment: " + String.format("%.2f",  carRental.getInvoice().totalPayment()));
		
		scan.close();
	}
}
