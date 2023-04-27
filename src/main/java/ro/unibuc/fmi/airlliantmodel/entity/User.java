package ro.unibuc.fmi.airlliantmodel.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
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
@NamedQuery(
        name = "User.findByIdAndLock",
        query = "SELECT u " +
                "FROM User u " +
                "WHERE u.id = :id",
        lockMode = LockModeType.PESSIMISTIC_WRITE
)
public class User {

    @Schema(description = "ID autogenerated by database.")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Schema(required = true)
    @NotNull(message = "First name must not be null.")
    @Size(min = 1, max = 50)
    private String firstName;

    @Schema(required = true)
    @NotNull(message = "Last name must not be null.")
    @Size(min = 1, max = 50)
    private String lastName;

    @Schema(required = true)
    @NotNull(message = "Email name must not be null.")
    @Size(min = 1, max = 50)
    @Email
    private String email;

    @Schema(required = true)
    @NotNull(message = "IsNotifiable must not be null.")
    private Boolean isNotifiable;

    @Schema(required = true)
    @NotNull(message = "Balance must not be null.")
    @DecimalMin(value = "0.00", message = "Balance value must be higher or equal than 0.00.")
    private BigDecimal balance;

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
        User that = (User) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
