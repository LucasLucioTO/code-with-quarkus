package styluscar.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import styluscar.car.dto.CreateCarDto;
import styluscar.service.dto.CreateServiceDto;
import styluscar.service.dto.UpdateServiceDto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="service")
public class Service {

    @Id @GeneratedValue
    private Long Id;

    @Column(name="type")
    private String type;

    @Column(name="staus")
    private boolean status;

    @Column(name="carId")
    private Long carId;

    @Column(name="functionaryId")
    private Long functionaryId;

    @Column(name="materialId")
    private Long materialId;

    @Column(name="quantityMaterial")
    private Long quantityMaterial;

    public void merge(UpdateServiceDto updateServiceDto){
        this.setId(updateServiceDto.getId());
        this.setType(updateServiceDto.getType());
        this.setStatus(updateServiceDto.isStatus());
        this.setCarId(updateServiceDto.getCarId());
        this.setFunctionaryId(updateServiceDto.getFunctionaryId());
        this.setMaterialId(updateServiceDto.getMaterialId());
        this.setQuantityMaterial(updateServiceDto.getQuantityMaterial());
    }

    public void buildService(CreateServiceDto createServiceDto){
        this.setType(createServiceDto.getType());
        this.setStatus(createServiceDto.isStatus());
        this.setCarId(createServiceDto.getCarId());
        this.setFunctionaryId(createServiceDto.getFunctionaryId());
        this.setMaterialId(createServiceDto.getMaterialId());
        this.setQuantityMaterial(createServiceDto.getQuantityMaterial());

    }


}
