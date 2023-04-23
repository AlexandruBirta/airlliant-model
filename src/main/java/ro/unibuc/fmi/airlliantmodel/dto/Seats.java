package ro.unibuc.fmi.airlliantmodel.dto;


import lombok.*;
import org.springframework.validation.annotation.Validated;


@Validated
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Seats {

    private SeatRow seatRowA;
    private SeatRow seatRowB;
    private SeatRow seatRowC;
    private SeatRow seatRowD;
    private SeatRow seatRowE;
    private SeatRow seatRowF;

}
