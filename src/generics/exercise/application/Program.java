package generics.exercise.application;

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
import java.util.Locale;

import generics.exercise.entities.Product;
import generics.exercise.services.CalculationService;

public class Program {

	public static void main(String[] args) throws IOException {

		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();

		Path path = Paths.get(System.getProperty("user.home"), "Documents", "in.txt");
		
		if(Files.notExists(path))
			Files.createFile(path);
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()))){
			writer.write("TV,1200");
			writer.newLine();
			writer.write("Computador,1500");
			writer.newLine();
			writer.write("Geladeira,2000");
			
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {

			String line;
			while ((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
			}
			
			Product mostExpensive = CalculationService.max(list);
			System.out.println("Most expensive:");
			System.out.println(mostExpensive);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
	}
}
