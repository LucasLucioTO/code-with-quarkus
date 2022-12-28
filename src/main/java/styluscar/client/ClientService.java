package styluscar.client;


import styluscar.client.dto.CreateClientDto;
import styluscar.client.dto.UpdateClientDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ClientService {
    @Inject
    ClientRepository repository;

    public Client findClientById(Long id) {
        return this.repository.findById(id);
    }

    public List<Client> findAllClient() {
        return this.repository.listAll();
    }

    public Client createClient(CreateClientDto createClientDto) {
        Client client = new Client();
        client.buildClient(createClientDto);
        this.repository.persist(client);
        return client;
    }
    public Client updateClient (UpdateClientDto updateClientDto){
        Client client = this.findClientById(updateClientDto.getId());
        if (client == null){
            throw new RuntimeException("Cliente não encontrado");
        }
        client.merge(updateClientDto);
        this.repository.persist(client);
        return client;

    }

    public boolean deleteClient(Long id) {
        if (this.repository.delete("id", id) < 1) {
            throw new RuntimeException("Carro não foi apagado");
        }
        return true;
    }

}
