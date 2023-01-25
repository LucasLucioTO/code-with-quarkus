package styluscar.car.dto;

import io.smallrye.common.constraint.NotNull;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CreateCarDto {

    @NotNull
    private String model;

    @NotNull
    private String color;

    @NotNull
    private String brand;

    @NotNull
    private String plate;


//    @NotNull
//    private Long clientId;
    private LocalDateTime dateEnter;

    private LocalDateTime dateExit;

}
