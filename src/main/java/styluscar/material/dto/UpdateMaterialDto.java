package styluscar.material.dto;


import io.smallrye.common.constraint.NotNull;
import lombok.Data;

@Data
public class UpdateMaterialDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long quantity;
}
