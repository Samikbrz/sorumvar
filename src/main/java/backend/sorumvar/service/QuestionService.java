package backend.sorumvar.service;

import backend.sorumvar.model.Question;
import backend.sorumvar.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

     public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    @Transactional
    public Question addQuestion(Question question){
         return questionRepository.save(question);
    }
}
