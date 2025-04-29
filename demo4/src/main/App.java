package main;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;

public class App {
	private static String csvPath = "C:\\pleiades\\2023-12\\workspace\\demo4\\src\\resources\\student_scores.csv";
	
	public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader(csvPath))) {
            List<String[]> records = reader.readAll();
            for (String[] record : records) {
                for (String field : record) {
                    System.out.print(field + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
