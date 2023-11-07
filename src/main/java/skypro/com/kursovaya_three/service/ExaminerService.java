package skypro.com.kursovaya_three.service;

import skypro.com.kursovaya_three.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection <Question> getQuestions (int amount);
}
