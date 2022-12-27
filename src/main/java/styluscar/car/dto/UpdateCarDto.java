package styluscar.car.dto;

import io.smallrye.common.constraint.NotNull;
import lombok.Data;

@Data
public class UpdateCarDto {
    @NotNull
    private Long id;

    private String model;

    private String color;

    private String brand;

    private String plate;

    private Long clientId;

}
