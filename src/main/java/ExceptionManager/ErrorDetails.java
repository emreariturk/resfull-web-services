package ExceptionManager;

import java.time.LocalDateTime;

public class ErrorDetails {
    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public LocalDateTime getTimestap() {
        return timestap;
    }

    private LocalDateTime timestap;

    private String errorCode;
    private String errorMessage;


    public ErrorDetails(LocalDateTime timestap, String errorCode, String errorMessage) {
        super();
        this.timestap = timestap;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
