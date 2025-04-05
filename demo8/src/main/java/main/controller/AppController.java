package main.controller;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.opencsv.CSVReader;

import main.logic.ScoreAnalyze;

@Controller
public class AppController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/analyze")
    public String analyze(Model model) {
        ClassPathResource resource = new ClassPathResource("student_scores.csv");

        try (CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream(), "UTF-8"))) {

            List<String[]> records = reader.readAll();
            ScoreAnalyze analyzer = new ScoreAnalyze();
            Map<String, Object> result = analyzer.analyze(records);

            model.addAllAttributes(result); // Thymeleaf に渡す

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "CSVの解析中にエラーが発生しました。");
        }

        return "result";
    }
}
