package interfaces.exercise.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private int idNumber;
	private double value;
	private Date initialDate;
	
	private List<Installment> installmentList = new ArrayList<>();
	
	public Contract(int idNumber, double value, Date initialDate) {
		this.idNumber = idNumber;
		this.value = value;
		this.initialDate = initialDate;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public double getValue() {
		return value;
	}

	public Date getInitialDate() {
		return initialDate;
	}
	
	public List<Installment> getInstallmentList() {
		return installmentList;
	}
	
	public void addInstallment(Installment installment) {
		this.installmentList.add(installment);
	}
}
