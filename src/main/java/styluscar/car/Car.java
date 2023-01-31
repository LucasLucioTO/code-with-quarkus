package styluscar.car;

import lombok.*;
import styluscar.client.Client;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id @GeneratedValue()
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "brand")
    private String brand;

    @Column(name = "plate")
    private String plate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "client_id",
        referencedColumnName = "id",
        foreignKey = @ForeignKey(name = "fk_car_client"),
        nullable = false)
    private Client client;

    @Column(name="date_enter", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateEnter;

    @Column(name="date_exit", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateExit;

}


