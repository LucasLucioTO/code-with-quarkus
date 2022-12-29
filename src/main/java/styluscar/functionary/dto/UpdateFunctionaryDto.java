package styluscar.functionary.dto;

import io.smallrye.common.constraint.NotNull;
import lombok.Data;

@Data
public class UpdateFunctionaryDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String phone;
}
