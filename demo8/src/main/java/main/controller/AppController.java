package main.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;

import main.logic.ScoreAnalyze;

@Controller
public class AppController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @PostMapping("/analyze")
    public String analyze(@RequestParam("file") MultipartFile file, Model model) {

        if (file.isEmpty()) {
            model.addAttribute("error", "CSVファイルが選択されていません。");
            return "index";
        }

        try (
            CSVReader reader = new CSVReader(
                new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8)))
        ) {
            List<String[]> records = reader.readAll();
            ScoreAnalyze analyzer = new ScoreAnalyze();
            Map<String, Object> result = analyzer.analyze(records);

            model.addAttribute("analysis", Map.of(
                "count", result.get("studentCount"),
                "avgEnglish", result.get("englishAverage"),
                "avgMath", result.get("mathAverage"),
                "avgScience", result.get("scienceAverage")
            ));

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "CSVの解析中にエラーが発生しました。");
        }

        return "index";
    }
}
