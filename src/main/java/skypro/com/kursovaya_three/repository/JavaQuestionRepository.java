package skypro.com.kursovaya_three.repository;

import skypro.com.kursovaya_three.exception.BadRequestException;
import skypro.com.kursovaya_three.exception.NotFoundException;
import skypro.com.kursovaya_three.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JavaQuestionRepository implements QuestionRepository{
    private final Set<Question> questions = new HashSet<>();

    private void init() {
        questions.add(new Question("Вопрос?", "Нет"));
        questions.add(new Question("Вопрос 1", "Да"));
        questions.add(new Question("Вопрос 2", "Ответ 2"));
        questions.add(new Question("Вопрос 3", "Ответ 3"));
        questions.add(new Question("Вопрос 4", "Ответ 4"));
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
