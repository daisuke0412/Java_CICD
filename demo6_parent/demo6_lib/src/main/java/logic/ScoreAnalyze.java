package logic;

import java.util.List;

public class ScoreAnalyze {

	public void analyze(List<String[]> records) {
		// 最初の行（ヘッダー）を削除する
	    records.remove(0);
	    
		// 生徒数
		int studentCount = records.size();

		// 各科目の平均を求める
		int englishTotal = 0;
		int japaneseTotal = 0;
		int mathTotal = 0;
		int scienceTotal = 0;
		int socialTotal = 0;

		for (String[] record : records) {
			englishTotal += Integer.parseInt(record[1]);
			japaneseTotal += Integer.parseInt(record[2]);
			mathTotal += Integer.parseInt(record[3]);
			scienceTotal += Integer.parseInt(record[4]);
			socialTotal += Integer.parseInt(record[5]);
		}

		int englishAverage = englishTotal / studentCount;
		int japaneseAverage = japaneseTotal / studentCount;
		int mathAverage = mathTotal / studentCount;
		int scienceAverage = scienceTotal / studentCount;
		int socialAverage = socialTotal / studentCount;

		// 出力
		System.out.println("student count: " + studentCount);
		System.out.println("---average---");
		System.out.println("japanese: " + englishAverage);
		System.out.println("english: " + japaneseAverage);
		System.out.println("math: " + mathAverage);
		System.out.println("science: " + scienceAverage);
		System.out.println("social: " + socialAverage);

	}
}
