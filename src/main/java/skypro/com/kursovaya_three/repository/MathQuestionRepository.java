package skypro.com.kursovaya_three.repository;

import org.springframework.stereotype.Repository;
import skypro.com.kursovaya_three.exception.BadRequestException;
import skypro.com.kursovaya_three.exception.NotFoundException;
import skypro.com.kursovaya_three.model.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository{

    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        questions.add(new Question("MathQuestion1", "Answer1"));
        questions.add(new Question("MathQuestion2", "Answer2"));
        questions.add(new Question("MathQuestion3", "Answer3"));
        questions.add(new Question("MathQuestion4", "Answer4"));
        questions.add(new Question("MathQuestion5", "Answer5"));
    }
    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new BadRequestException("Напиши вопрос");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new NotFoundException("Вопрос не найден");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
