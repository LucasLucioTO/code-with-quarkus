package styluscar.client;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import styluscar.client.dto.CreateClientDto;
import styluscar.client.dto.UpdateClientDto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    public void merge(UpdateClientDto updateClientDto){
        this.setName(updateClientDto.getName());
        this.setPhone(updateClientDto.getPhone());
        this.setStatus(updateClientDto.getStatus());
    }
    public void buildClient(CreateClientDto createClientDto){
        this.setName(createClientDto.getName());
        this.setPhone(createClientDto.getPhone());
        this.setStatus(createClientDto.getStatus());

    }
}
