package backend.sorumvar.controller;

import backend.sorumvar.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/question")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/{questionId}/image")
    public void uploadImage(@RequestParam("image") MultipartFile image, @PathVariable long questionId) throws IOException {
        imageService.uploadImage(image,questionId);
    }
}
