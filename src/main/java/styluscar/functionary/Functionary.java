package styluscar.functionary;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
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

}
