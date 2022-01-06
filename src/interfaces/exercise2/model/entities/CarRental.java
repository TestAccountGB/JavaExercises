package interfaces.exercise2.model.entities;

import java.util.Calendar;

public class CarRental {

	private Calendar start;
	private Calendar finish;
	
	private Vehicle vehicle;
	
	private Invoice invoice;

	public CarRental(Calendar start, Calendar finish, Vehicle vehicle) {
		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle;
		//Nao colocamos o invoice, pois ele pode comecar como nulo, porque o sistema pode nao ter calculado a fatura ainda
	}

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	public Calendar getFinish() {
		return finish;
	}

	public void setFinish(Calendar finish) {
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
