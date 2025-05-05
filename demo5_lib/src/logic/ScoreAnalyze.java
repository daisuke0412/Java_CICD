package logic;

import java.util.List;

public class ScoreAnalyze {

	public void analyze(List<String[]> records) {
		// remove header
	    records.remove(0);
	    
		int studentCount = records.size();

		// calculate average
		int englishTotal = 0;
		int mathTotal = 0;
		int scienceTotal = 0;

		for (String[] record : records) {
			englishTotal += Integer.parseInt(record[1]);
			mathTotal += Integer.parseInt(record[2]);
			scienceTotal += Integer.parseInt(record[3]);
		}

		int englishAverage = englishTotal / studentCount;
		int mathAverage = mathTotal / studentCount;
		int scienceAverage = scienceTotal / studentCount;

		// output
		System.out.println("student count: " + studentCount);
		System.out.println("---average---");
		System.out.println("english: " + englishAverage);
		System.out.println("math: " + mathAverage);
		System.out.println("science: " + scienceAverage);

	}
}

