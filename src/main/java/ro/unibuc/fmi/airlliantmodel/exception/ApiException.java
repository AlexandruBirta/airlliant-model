package ro.unibuc.fmi.airlliantmodel.exception;


import lombok.Getter;


@Getter
public class ApiException extends RuntimeException {

    private final ExceptionStatus exceptionStatus;
    private final String errorMessage;
    private final String[] errorParameters;

    public ApiException(ExceptionStatus exceptionStatus, String... errorParameters) {
        this.exceptionStatus = exceptionStatus;
        this.errorParameters = errorParameters;
        this.errorMessage = String.format(exceptionStatus.toString(), (Object[]) errorParameters);
    }

    public ApiException(ExceptionStatus exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
        this.errorMessage = exceptionStatus.toString();
        this.errorParameters = null;
    }

}