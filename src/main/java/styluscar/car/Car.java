package styluscar.car;

import java.time.LocalDateTime;
import javax.json.bind.annotation.JsonbDateFormat;
import lombok.*;
import styluscar.car.dto.CreateCarDto;
import styluscar.car.dto.UpdateCarDto;


import javax.persistence.*;

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

//    @Column(name = "clientId")
//    private Long clientId;

    @Column(name="date_enter", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateEnter;

    @Column(name="date_exit", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateExit;

    public void merge(UpdateCarDto carDto) {
        this.setModel(carDto.getModel());
        this.setColor(carDto.getColor());
        this.setBrand(carDto.getBrand());
        this.setPlate(carDto.getPlate());
        //this.setClientId(carDto.getClientId());
        this.setDateEnter(carDto.getDateEnter());
        this.setDateExit(carDto.getDateExit());
    }

}


