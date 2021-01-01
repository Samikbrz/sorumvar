package backend.sorumvar;

import backend.sorumvar.dto.ErrorResponse;
import backend.sorumvar.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.IOException;

public class ApiExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleApiException(NotFoundException ex) {
        return new ErrorResponse("404", ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IOException.class)
    public ErrorResponse handleIOException(IOException ex) {
        return new ErrorResponse("400",  "Something went wrong while uploading!");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ErrorResponse handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return new ErrorResponse("417", "File too large!");
    }
}
