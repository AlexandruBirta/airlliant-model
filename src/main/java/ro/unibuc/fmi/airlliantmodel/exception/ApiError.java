package ro.unibuc.fmi.airlliantmodel.exception;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;


@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Schema
public class ApiError {

    @Schema
    @Builder.Default
    private final String errorMessage = ExceptionStatus.AIRLLIANT_INTERNAL_ERROR.getValue();

    @Schema
    @Builder.Default
    private final ExceptionStatus.ErrorCode errorCode = ExceptionStatus.ErrorCode.AIRLLIANT_INTERNAL_ERROR;

    @Schema
    @Builder.Default
    private final LocalDateTime timestamp = LocalDateTime.now();

}