package skypro.com.kursovaya_three.service;

import org.springframework.beans.factory.annotation.Autowired;
import skypro.com.kursovaya_three.model.Question;

import java.util.Collection;
import java.util.Random;

public class UtilService {

    private Random random;

    @Autowired
    public void setRandom(Random random) {
        this.random = random;
    }

    public Question getRandomQuestion(Collection<Question> questions) {
        int questionNum = getRandomInt(questions.size());
        int questionCur = 0;
        for (Question question : questions) {
            if (questionCur == questionNum) {
                return question;
            }
            questionCur++;
        }
        return null;
    }

    public Integer getRandomInt(int bound) {
        return random.nextInt(bound);
    }
}
