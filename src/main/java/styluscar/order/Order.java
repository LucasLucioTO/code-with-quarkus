package styluscar.order;

import lombok.Data;
import styluscar.car.Car;
import styluscar.functionary.Functionary;
import styluscar.material.Material;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Table(name="service")
public class Order {

    @Id @GeneratedValue
    private Long Id;

    @Column(name="type")
    private String type;

    @Column(name="staus")
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="car_Id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_order_car"),
            nullable = false)
    private Car car;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="functionary_Id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_order_car"),
            nullable = false)
    private Functionary functionary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="materialId",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_order_car"),
            nullable = false
    )
    private Material material;

    @Column(name="quantityMaterial")
    private Long quantityMaterial;



}
