package styluscar.service.dto;

import io.smallrye.common.constraint.NotNull;
import lombok.Data;


@Data
public class UpdateServiceDto {

    @NotNull
    private Long Id;

    @NotNull
    private String type;

    @NotNull
    private boolean status;

    @NotNull
    private Long carId;

    @NotNull
    private Long functionaryId;

    @NotNull
    private Long materialId;

    @NotNull
    private Long quantityMaterial;
}
