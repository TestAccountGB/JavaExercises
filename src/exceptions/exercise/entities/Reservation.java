package exceptions.exercise.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import exceptions.exercise.exceptions.CheckoutException;
import exceptions.exercise.exceptions.OlderDateException;

public class Reservation {
	private static SimpleDateFormat customDate = new SimpleDateFormat("dd/MM/yyyy");
	private int roomNumber;
	private Calendar checkin;
	private Calendar checkout;

	public Reservation(int roomNumber, Calendar checkin, Calendar checkout) throws CheckoutException {
		checkoutVerification(checkin, checkout);
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reservation: " + this.roomNumber);
		sb.append(", check-in: " + customDate.format(this.checkin.getTime()));
		sb.append(", check-out: " + customDate.format(this.checkout.getTime()));
		sb.append(", duration: " + duration() + " nights");

		return sb.toString();
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Calendar getCheckin() {
		return checkin;
	}

	public void setCheckin(Calendar checkin) {
		this.checkin = checkin;
	}

	public Calendar getCheckout() {
		return checkout;
	}

	public void setCheckout(Calendar checkout) {
		this.checkout = checkout;
	}

	public void updateDates(Calendar checkin, Calendar checkout) throws CheckoutException, OlderDateException {
		updateVerification(checkin, checkout);
		setCheckin(checkin);
		setCheckout(checkout);
	}

	private boolean checkoutVerification(Calendar checkin, Calendar checkout) throws CheckoutException {

		if (checkin.getTimeInMillis() < checkout.getTimeInMillis()) {
			return true;
		}
		
		throw new CheckoutException();
	}

	private boolean updateVerification(Calendar checkin, Calendar checkout)
			throws CheckoutException, OlderDateException {
		
		checkoutVerification(checkin, checkout);
		
		if (this.checkout.getTimeInMillis() < checkin.getTimeInMillis()) {
			return true;
		}
		
		throw new OlderDateException();
	}
	
	public int duration() {
		long difference = this.checkout.getTimeInMillis() - this.checkin.getTimeInMillis();
		return (int) TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
		//Para usar o metodo primeiramente chamamos a enumeracao TimeUnit, depois usamos o tipo de dado que
		//Queremos, no meu caso eu quero dia, depois usamos o metodo "convert" que temos que especificar 
		//O tipo de dado que estamos passando, no meu caso foi milissegundos
	}
	
	
	//Metodo sem usar o TimeUnit...
//	public int duration() {
//		if (this.checkout.get(Calendar.YEAR) == this.checkin.get(Calendar.YEAR)) {
//			int duration = this.checkout.get(Calendar.DAY_OF_YEAR) - this.checkin.get(Calendar.DAY_OF_YEAR);
//			return duration;
//		}
//
//		int restOfTheYear = this.checkin.getActualMaximum(Calendar.DAY_OF_YEAR)
//				- this.checkin.get(Calendar.DAY_OF_YEAR);
//		int difference = this.checkout.get(Calendar.YEAR) - this.checkin.get(Calendar.YEAR);
//
//		if (difference == 1) {
//			return restOfTheYear + this.checkout.get(Calendar.DAY_OF_YEAR);
//		}
//
//		int duration = 0;
//		for (int i = 1; i < difference; i++) {
//			this.checkin.set(Calendar.YEAR, this.checkin.get(Calendar.YEAR) + 1);
//			duration += this.checkin.getActualMaximum(Calendar.DAY_OF_YEAR);
//		}
//
//		duration += this.checkout.get(Calendar.DAY_OF_YEAR) + restOfTheYear;
//		return duration;
//	}
	//Sim, eu fiz isso a toa :(
}
