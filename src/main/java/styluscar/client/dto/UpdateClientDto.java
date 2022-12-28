package styluscar.client.dto;

import io.smallrye.common.constraint.NotNull;
import lombok.Data;

@Data
public class UpdateClientDto {
    @NotNull
    private Long id;

    private String name;

    private String phone;

    private Boolean status;
}
