package skypro.com.kursovaya_three.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import skypro.com.kursovaya_three.exception.BadRequestException;
import skypro.com.kursovaya_three.model.Question;
import skypro.com.kursovaya_three.repository.QuestionRepository;

import java.util.Collection;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;
    private final UtilService utilService;

    public MathQuestionService(@Qualifier ("mathQuestionRepository") QuestionRepository questionRepository,
                               UtilService utilService) {
        this.questionRepository = questionRepository;
        this.utilService = utilService;
    }

    @Override
    public Question add(String question, String answer) {
        if (question == null || question.isBlank()) {
            throw new BadRequestException("Некорректный вопрос");
        }
        if (answer == null || answer.isBlank()) {
            throw new BadRequestException("Некорректный ответ");
        }
        return questionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return utilService.getRandomQuestion (questionRepository.getAll());
    }
}
