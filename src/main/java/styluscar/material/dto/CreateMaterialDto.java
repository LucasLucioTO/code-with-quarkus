package styluscar.material.dto;

import io.smallrye.common.constraint.NotNull;
import lombok.Data;

@Data
public class CreateMaterialDto {

    @NotNull
    private String name;

    @NotNull
    private Long quantity;
}
