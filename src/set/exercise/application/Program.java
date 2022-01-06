package set.exercise.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import set.exercise.model.entities.UserLog;

public class Program {
	public static void main(String[] args) throws IOException {

		Set<UserLog> userLogs = new HashSet<>();
		SimpleDateFormat customDate = new SimpleDateFormat("yyyy-MM-dd'|'HH:mm:ss");
		
		Path path = Paths.get(System.getProperty("user.home"), "Documents", "EntradaDeUsuarios.txt");
		
		if(Files.notExists(path))
			Files.createFile(path);
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()))){
			writer.write("amanda 2018-08-26|20:45:08");
			writer.newLine();
			writer.write("alex86 2018-08-26|21:49:37");
			writer.newLine();
			writer.write("bobbrown 2018-08-27|03:19:13");
			writer.newLine();
			writer.write("amanda 2018-08-27|08:11:00");
			writer.newLine();
			writer.write("jeniffer3 2018-08-27|09:19:24");
			writer.newLine();
			writer.write("alex86 2018-08-27|22:39:52");
			writer.newLine();
			writer.write("amanda 2018-08-28|07:42:19");
			
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {
			
			String message;
			
			while((message = reader.readLine()) != null) {
				String[] usersInformation = message.split(" ");
				String name = usersInformation[0];
				Date date = customDate.parse(usersInformation[1]);
				UserLog userLog = new UserLog(name, date);
				userLogs.add(userLog);
			}
			
			System.out.println("Total users: " + userLogs.size());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
