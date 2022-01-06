package map.exercise.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Program {
	public static void main(String[] args) throws IOException {
		
		Map<String, Integer> map = new HashMap<>();
		Path path = Paths.get(System.getProperty("user.home"), "Documents", "Votos.txt");
		
		if(Files.notExists(path))
			Files.createFile(path);
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()))){
			writer.write("Alex Blue,15");
			writer.newLine();
			writer.write("Maria Green,22");
			writer.newLine();
			writer.write("Bob Brown,21");
			writer.newLine();
			writer.write("Alex Blue,30");
			writer.newLine();
			writer.write("Bob Brown,15");
			writer.newLine();
			writer.write("Maria Green,27");
			writer.newLine();
			writer.write("Maria Green,22");
			writer.newLine();
			writer.write("Bob Brown,25");
			writer.newLine();
			writer.write("Alex Blue,31");
			
		}
		
		try(BufferedReader reader = new BufferedReader(new FileReader(path.toString()))){
			
			String message;
			
			while((message = reader.readLine()) != null) {
				String[] personVotes = message.split(",");
				String name = personVotes[0];
				Integer votes = Integer.parseInt(personVotes[1]);
				if(map.containsKey(name)) {
					map.put(name, map.get(name) + votes);
					continue;
				}
				map.put(name, votes);
			}
			
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				System.out.print("Person: " + entry.getKey());
				System.out.println(", Votes: " + entry.getValue());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
