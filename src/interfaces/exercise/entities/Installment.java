package interfaces.exercise.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	
	private double valueTaxed;
	private Date dates;
	private SimpleDateFormat customDate = new SimpleDateFormat("dd/MM/yyyy");
	
	public Installment(Date dates, double valueTaxed) {
		this.dates = dates;
		this.valueTaxed = valueTaxed;
	}

	@Override
	public String toString() {
		return customDate.format(dates.getTime()) + " - " + this.valueTaxed;
	}

	public Date getdates() {
		return dates;
	}

	public void dates(Date dates) {
		this.dates = dates;
	}

	public double getValueTaxed() {
		return valueTaxed;
	}

	public void setValueTaxed(double valueTaxed) {
		this.valueTaxed = valueTaxed;
	}

}
