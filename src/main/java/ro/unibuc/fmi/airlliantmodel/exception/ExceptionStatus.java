package ro.unibuc.fmi.airlliantmodel.exception;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum ExceptionStatus {

    AIRLLIANT_INTERNAL_ERROR("Application encountered an unexpected error.", ErrorCode.AIRLLIANT_INTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);

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
            "* `AIE_022` - AIRLLIANT_INTERNAL_ERROR\n" +
            "* `ANF_023` - AIRLLIANT_NOT_FOUND\n" +
            "* `ABR_024` - AIRLLIANT_BAD_REQUEST\n" +
            "* `AFB_041` - AIRLLIANT_FORBIDDEN\n" +
            "")
    public enum ErrorCode {

        AIRLLIANT_INTERNAL_ERROR("AIE_022"),
        AIRLLIANT_NOT_FOUND("ANF_023"),
        AIRLLIANT_BAD_REQUEST("ABR_024"),
        AIRLLIANT_FORBIDDEN("AFB_041");
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