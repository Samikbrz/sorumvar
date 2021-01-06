package backend.sorumvar.service;

import backend.sorumvar.exception.NotFoundException;
import backend.sorumvar.model.ImageInfo;
import backend.sorumvar.model.Question;
import backend.sorumvar.repository.ImageRepository;
import backend.sorumvar.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Value("${upload.dir}")
    private String uploadDir;

    @Transactional
    public void uploadImage(MultipartFile image,long questionId) throws IOException {

        Optional<Question> optionalQuestion=questionRepository.findById(questionId);
        if(!optionalQuestion.isPresent()){
            throw new NotFoundException("Question is not found");
        }

        // Set up location for upload
        Path rootLocation = Paths.get(uploadDir);
        Path absolutePath = rootLocation.normalize().toAbsolutePath();

        // Create upload folder by date
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(currentDate);

        File file = new File(absolutePath + "/" + formattedDate);
        file.mkdir();

        // Upload image to file system
        InputStream is = null;
        is = image.getInputStream();
        String destinationFile =  absolutePath + "/" + formattedDate + "/" + image.getOriginalFilename();
        Files.copy(is, Paths.get(destinationFile));

        // Save image info
        ImageInfo imageInfo = new ImageInfo();
        Question question = optionalQuestion.get();
        imageInfo.setQuestion(question);
        String path = formattedDate + "/" + image.getOriginalFilename();
        imageInfo.setPath(path);
        imageRepository.save(imageInfo);
    }

}
