package backend.sorumvar.controller;

import backend.sorumvar.model.Question;
import backend.sorumvar.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question addQuestion(Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
    }

}
