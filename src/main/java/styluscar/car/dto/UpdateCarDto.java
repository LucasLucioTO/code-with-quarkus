package styluscar.car.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateCarDto {
  private String model;

  private String color;

  private String brand;

  private String plate;

  private Long clientId;

  private LocalDateTime dateEnter;

  private LocalDateTime dateExit;


}
