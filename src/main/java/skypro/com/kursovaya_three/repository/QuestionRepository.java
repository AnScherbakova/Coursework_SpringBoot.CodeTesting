package skypro.com.kursovaya_three.repository;

import skypro.com.kursovaya_three.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add (Question question);
    Question remove (Question question);
    Collection <Question> getAll ();
}
