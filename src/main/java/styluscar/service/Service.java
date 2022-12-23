package styluscar.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name="carId")
    private Long carId;
    @Column(name="functionaryId")
    private Long functionaryId;
    @Column(name="materialId")
    private Long materialId;
    @Column(name="quantityMaterial")
    private Long quantityMaterial;

}
