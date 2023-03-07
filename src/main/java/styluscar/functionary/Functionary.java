package styluscar.functionary;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
