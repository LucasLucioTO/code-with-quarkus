package styluscar.functionary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import styluscar.client.dto.UpdateClientDto;
import styluscar.functionary.dto.CreateFunctionaryDto;
import styluscar.functionary.dto.UpdateFunctionaryDto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="functionary")
public class Functionary {
    @Id @GeneratedValue
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="phone")
    private String phone;

    public void merge(UpdateFunctionaryDto updateFunctionaryDto){
        this.setId(updateFunctionaryDto.getId());
        this.setName(updateFunctionaryDto.getName());
        this.setPhone(updateFunctionaryDto.getPhone());
    }
    public void buildFunctionary(CreateFunctionaryDto createFunctionaryDto){
        this.setName(createFunctionaryDto.getName());
        this.setPhone(createFunctionaryDto.getPhone());
    }

}
