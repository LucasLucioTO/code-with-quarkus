package styluscar.client.dto;

import io.smallrye.common.constraint.NotNull;
import lombok.Data;
@Data
public class CreateClientDto {

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private Boolean status;
}
