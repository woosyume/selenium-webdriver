package demo;

import java.util.List;

import demo.utilities.CSV;

public class DataReaders {
	public static void main(String[] args) {
		readCsv();
	}
	
	public static void readCsv() {
		String filename = "/Users/woohyeok.kim/Downloads/UserAccounts.csv"; // for Mac
		List<String[]> records = CSV.get(filename);
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
		
	}
}
