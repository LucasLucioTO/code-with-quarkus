package styluscar.material;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import styluscar.material.dto.CreateMaterialDto;
import styluscar.material.dto.UpdateMaterialDto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private Long quantity;

    public void merge(UpdateMaterialDto updateMaterialDto) {
        this.setId(updateMaterialDto.getId());
        this.setName(updateMaterialDto.getName());
        this.setQuantity(updateMaterialDto.getQuantity());

    }

    public void buildMaterial(CreateMaterialDto createMaterialDto){
        this.setName(createMaterialDto.getName());
        this.setQuantity(createMaterialDto.getQuantity());
    }
}
