package interfaces.exercise.services;

import java.util.Calendar;
import java.util.Date;

import interfaces.exercise.entities.Contract;
import interfaces.exercise.entities.Installment;

public class ContractTax {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractTax(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int month) {
		double value = contract.getValue() / month;
		
		for(int i = 1; i <= month; i++) {
			double valueTaxed = onlinePaymentService.tax(value, i) + value;
			Date date = nextMonth(contract.getInitialDate(), i).getTime();
			Installment installment = new Installment(date, valueTaxed);
			contract.addInstallment(installment);
		}
	}
	
	public Calendar nextMonth(Date initialDate, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(initialDate);
		calendar.add(Calendar.MONTH, month);
		return calendar;
	}
}
