package br.com.sistemaponto.exception.intercept;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handleException(final Exception e, final HttpServletRequest request) {

        if (e instanceof ApplicationException) {
            final StandardError standardError = new StandardError(Instant.now(),
                    ((ApplicationException) e).getHttpStatus().value(),
                    e.getLocalizedMessage(),
                    e.getMessage(),
                    request.getRequestURI());
            return ResponseEntity.status(standardError.getStatus()).body(standardError);
        }

        final StandardError standardError = new StandardError(Instant.now(),
                500,
                e.getLocalizedMessage(),
                "Ocorreu um erro inesperado!",
                request.getRequestURI());

        e.printStackTrace();

        return ResponseEntity.status(standardError.getStatus()).body(standardError);
    }
}
