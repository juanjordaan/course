package cloud.jordaan.juan.csg.interfaces.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	private Logger logger = LogManager.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleThrowable(MethodArgumentNotValidException e) {
		logger.error(e.getMessage(), e);

		List<Error> errors = e.getBindingResult()
			.getAllErrors()
			.stream()
			.map(error -> new Error("Validation Error", error.getDefaultMessage()))
			.collect(Collectors.toList());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e) {
		logger.error(e.getMessage(), e);

        return new ResponseEntity<>( e.getMessage(), HttpStatus.BAD_REQUEST);
    }

	@ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handleThrowable(Throwable e) {
		logger.error(e.getMessage(), e);

        return new ResponseEntity<>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
