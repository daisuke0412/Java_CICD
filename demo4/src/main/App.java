package main;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;

public class App {
	public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("student_scores.csv"))) {
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
