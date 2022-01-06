package interfaces.exercise.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import interfaces.exercise.entities.Contract;
import interfaces.exercise.entities.Installment;
import interfaces.exercise.services.ContractTax;
import interfaces.exercise.services.PaypalService;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat customDate = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int idNumber = scan.nextInt();
		
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = customDate.parse(scan.next());
		
		System.out.print("Contract value: ");
		double contractValue = scan.nextDouble();
		
		System.out.print("Enter the number of installments: ");
		int installmentsQuantity = scan.nextInt();
		
		Contract contract = new Contract(idNumber, contractValue, date);
		ContractTax contractTax = new ContractTax(new PaypalService());
		contractTax.processContract(contract, installmentsQuantity);
		
		for(Installment installment : contract.getInstallmentList()) {
			System.out.println(installment);
		}
		
		scan.close();
	}
}
