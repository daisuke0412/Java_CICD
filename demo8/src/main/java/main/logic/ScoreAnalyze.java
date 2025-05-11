package main.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreAnalyze {

    public Map<String, Object> analyze(List<String[]> records) {
        records.remove(0); // ヘッダーを除く

        int studentCount = records.size();
        int englishTotal = 0;
        int mathTotal = 0;
        int scienceTotal = 0;

        for (String[] record : records) {
            englishTotal += Integer.parseInt(record[1]);
            mathTotal += Integer.parseInt(record[2]);
            scienceTotal += Integer.parseInt(record[3]);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("studentCount", studentCount);
        result.put("englishAverage", englishTotal / studentCount);
        result.put("mathAverage", mathTotal / studentCount);
        result.put("scienceAverage", scienceTotal / studentCount);

        return result;
    }
}
