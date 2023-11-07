package skypro.com.kursovaya_three.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.com.kursovaya_three.model.Question;
import skypro.com.kursovaya_three.service.QuestionService;

import java.util.Collection;
@RestController
@RequestMapping("/exam/java")
public class MathQuestionController {

        private final QuestionService questionService;


        public MathQuestionController(QuestionService mathQuestionService) {
            this.questionService = mathQuestionService;
        }

        @GetMapping
        public Collection<Question> getQuestions() {
            return questionService.getAll();
        }

        @GetMapping("/add")
        public Question addQuestion(@RequestParam("question") String question,
                                    @RequestParam("answer") String answer) {
            return questionService.add(new Question(question, answer));
        }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }
    }

