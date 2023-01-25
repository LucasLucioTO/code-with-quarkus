package styluscar.car.dto;

import io.smallrye.common.constraint.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
