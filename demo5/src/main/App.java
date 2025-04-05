package main;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;

import logic.ScoreAnalyze;

public class App {
	public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("C:\\work\\cicd_demo\\resource\\student_scores.csv"))) {
            List<String[]> records = reader.readAll();
            ScoreAnalyze scoreAnalyze = new ScoreAnalyze();
            scoreAnalyze.analyze(records);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
