package streams.exercise.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import streams.exercise.entities.Employee;

public class Program {
	public static void main(String[] args) throws IOException {
		
		//Criacao do arquivo
		Path path = Paths.get(System.getProperty("user.home"), "Desktop", "Employee's Information.txt");
		
		if(Files.notExists(path))
			Files.createFile(path);
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()))){
			
			writer.write("Maria,maria@gmail.com,3200.00");
			writer.newLine();
			writer.write("Alex,alex@gmail.com,1900.00");
			writer.newLine();
			writer.write("Marco,marco@gmail.com,1700.00");
			writer.newLine();
			writer.write("Bob,bob@gmail.com,3500.00");
			writer.newLine();
			writer.write("Anna,anna@gmail.com,2800.00");
			writer.flush();
		}
		
/////////////////////////////////////////////////////////////////////////////
		
		//Leitura do arquivo
		
		Scanner scan = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(path.toString()))){
			
			String string;
			
			while((string = reader.readLine()) != null) {
				String[] fields = string.split(",");
				String name = fields[0];
				String email = fields[1];
				double salary = Double.parseDouble(fields[2]);
				employees.add(new Employee(name, email, salary));
			}	
		}
		
		System.out.print("Enter Salary: ");
		double salary = scan.nextDouble();
		
		System.out.printf("Email of people whose salary is more than %.2f:%n", salary);
		employees.stream()
		.filter((Employee e) -> e.getSalary() > salary)
		.map((Employee e) -> e.getEmail())
		.sorted()
		.forEach(System.out::println);
		
		System.out.print("Letter: ");
		char letter = scan.next().toUpperCase().charAt(0);
		
		double sum = employees.stream()
		.filter((Employee e) -> e.getName().toUpperCase().charAt(0) == letter)
		.mapToDouble(Employee::getSalary)
		.sum();
		System.out.printf("Sum of salary of peole whose name starts with '%c': %.2f", letter, sum);
		
		scan.close();
	}
}
