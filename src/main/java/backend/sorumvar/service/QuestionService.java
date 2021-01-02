package backend.sorumvar.service;

import backend.sorumvar.exception.NotFoundException;
import backend.sorumvar.model.Question;
import backend.sorumvar.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Question updateQuestion(Question question){
        Optional<Question> optionalQuestion=questionRepository.findById(question.getId());
        if(!optionalQuestion.isPresent()){
            throw new NotFoundException("Question is not found!");
        }
         return  questionRepository.save(question);
    }

    @Transactional
    public void deleteQuestion(Long id){
        Optional<Question> optionalQuestion=questionRepository.findById(id);
        if(!optionalQuestion.isPresent()){
            throw new NotFoundException("Question is not found!");
        }
        questionRepository.deleteById(id);
    }

}
