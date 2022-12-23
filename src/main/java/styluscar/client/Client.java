package styluscar.client;

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
@Table(name = "client")
public class Client {
    @Id @GeneratedValue
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="phone")
    private String phone;
    @Column(name="status")
    private Boolean status;
}
