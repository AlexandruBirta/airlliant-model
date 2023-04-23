package ro.unibuc.fmi.airlliantmodel.exception;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum ExceptionStatus {

    AIRLLIANT_INTERNAL_ERROR("Application encountered an unexpected error.", ErrorCode.AIRLLIANT_INTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR),
    USER_NOT_FOUND("User with id '%s' not found!", ErrorCode.USER_NOT_FOUND, HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS("User with id '%s' already exists!", ErrorCode.USER_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);


    private final String value;
    private final ErrorCode errorCode;
    private final HttpStatus httpStatus;

    ExceptionStatus(String value, ErrorCode errorCode, HttpStatus httpStatus) {
        this.value = value;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    @JsonCreator
    public static ExceptionStatus fromValue(String text) {
        for (ExceptionStatus b : ExceptionStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @Getter
    @Schema(enumAsRef = true, description = "Error codes description: \n" +
            "* `AIE_001` - AIRLLIANT_INTERNAL_ERROR\n" +
            "* `ANF_002` - AIRLLIANT_NOT_FOUND\n" +
            "* `ABR_003` - AIRLLIANT_BAD_REQUEST\n" +
            "* `AFB_004` - AIRLLIANT_FORBIDDEN\n" +
            "* `UNF_005` - USER_NOT_FOUND\n" +
            "* `UAE_006` - USER_ALREADY_EXISTS\n" +
            "")
    public enum ErrorCode {

        AIRLLIANT_INTERNAL_ERROR("AIE_001"),
        AIRLLIANT_NOT_FOUND("ANF_002"),
        AIRLLIANT_BAD_REQUEST("ABR_003"),
        AIRLLIANT_FORBIDDEN("AFB_004"),
        USER_NOT_FOUND("UNF_005"),
        USER_ALREADY_EXISTS("UAE_006");

        private final String value;

        ErrorCode(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ErrorCode fromValue(String text) {
            for (ErrorCode b : ErrorCode.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

    }

}