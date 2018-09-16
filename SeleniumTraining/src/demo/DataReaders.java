package demo;

import java.util.List;

import demo.utilities.CSV;
import demo.utilities.Excel;

public class DataReaders {
	public static void main(String[] args) {
		//readCsv();
		readExcel();
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
	
	public static void readExcel() {
		String filename = "/Users/woohyeok.kim/Downloads/UserLogin.xls";
		String[][] data = Excel.get(filename);
		for (String[] record : data) {
			System.out.println("\nNEW RECORD");
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);
		}
	}
}
