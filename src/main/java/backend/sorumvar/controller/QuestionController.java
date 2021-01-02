package backend.sorumvar.controller;

import backend.sorumvar.model.Question;
import backend.sorumvar.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

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

    @PutMapping("{/id}")
    public void updateQuestion(@RequestBody Question question,@PathVariable Long id){
        question.setId(id);
        questionService.updateQuestion(question);
    }

}
