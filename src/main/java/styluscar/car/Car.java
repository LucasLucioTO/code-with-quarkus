package styluscar.car;

import lombok.*;
import styluscar.car.dto.CreateCarDto;
import styluscar.car.dto.UpdateCarDto;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "brand")
    private String brand;

    @Column(name = "plate")
    private String plate;

    @Column(name = "clientId")
    private Long clientId;

    @Column(name="dateenter")
    private String dateEnter;

    @Column(name="dateexit")
    private String dateExit;

    public void merge(UpdateCarDto carDto) {
        this.setModel(carDto.getModel());
        this.setColor(carDto.getColor());
        this.setBrand(carDto.getBrand());
        this.setPlate(carDto.getPlate());
        this.setClientId(carDto.getClientId());
        this.setDateEnter(carDto.getDateEnter());
        this.setDateExit(carDto.getDateExit());
    }
    public void buildCar(CreateCarDto carDto) {
        this.setModel(carDto.getModel());
        this.setColor(carDto.getColor());
        this.setBrand(carDto.getBrand());
        this.setPlate(carDto.getPlate());
        this.setClientId(carDto.getClientId());
        this.setDateEnter(carDto.getDateEnter());
        this.setDateExit(carDto.getDateExit());
    }

}


