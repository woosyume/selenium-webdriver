package demo.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
	public static List<String[]> get(String filename) {
		List<String[]> data = new ArrayList<>();
		String testRow;
		
		try(
			BufferedReader reader = new BufferedReader(new FileReader(filename))
			) {
			
			while ((testRow = reader.readLine()) != null) {
				String[] line = testRow.split(",");
				data.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Could not read");
		}
		
		return data;
	}
}
