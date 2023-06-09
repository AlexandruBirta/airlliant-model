package ro.unibuc.fmi.airlliantmodel.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;


@Schema
@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Ticket {

    @Schema(description = "ID autogenerated by database.")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Schema(required = true)
    @NotNull(message = "Seat row must not be null.")
    @Size(min = 8, max = 8)
    private String seatRow;

    @Schema(required = true)
    @NotNull(message = "Seat number must not be null.")
    @Size(min = 5, max = 6)
    private String seatNumber;

    @Schema(required = true)
    @Size(min = 2, max = 4)
    private String gate;

    @Schema(required = true)
    @Valid
    @JoinColumn(
            name = "flight_id",
            referencedColumnName = "id"
    )
    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE,
            orphanRemoval = true
    )
    private Flight flight;

    @Schema(hidden = true)
    @Valid
    @ToString.Exclude
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    @ManyToOne(
            targetEntity = User.class,
            fetch = FetchType.EAGER
    )
    private User user;

    @Schema(description = "Autogenerated ISO8601 timestamp upon creation.")
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime insertedDate;

    @Schema(description = "Autogenerated ISO8601 timestamp upon update.")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ticket that = (Ticket) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
