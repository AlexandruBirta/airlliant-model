package ro.unibuc.fmi.airlliantmodel.dto;


import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;


@Validated
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Seats implements Serializable {

    private SeatRow seatRowA;
    private SeatRow seatRowB;
    private SeatRow seatRowC;
    private SeatRow seatRowD;
    private SeatRow seatRowE;
    private SeatRow seatRowF;

}
