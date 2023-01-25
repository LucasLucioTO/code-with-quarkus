package styluscar.client;


import styluscar.client.dto.CreateClientDto;
import styluscar.client.dto.UpdateClientDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ClientService {
    @Inject
    ClientRepository cr;

    public Client findClientById(Long id) {
        return this.cr.findByIdOptional(id).orElseThrow(
            () -> new RuntimeException("erro ao buscar clientes" ));
    }

    public List<Client> findAllClient() {
        return this.cr.listAll();
    }

    public Client createClient(CreateClientDto createClientDto) {
        Client client = new Client();
        client.buildClient(createClientDto);
        this.cr.persist(client);
        return client;
    }
    public Client updateClient (UpdateClientDto updateClientDto){
        Client client = this.findClientById(updateClientDto.getId());
        if (client == null){
            throw new RuntimeException("Cliente não encontrado");
        }
        client.merge(updateClientDto);
        this.cr.persist(client);
        return client;

    }

    public boolean deleteClient(Long id) {
        if (this.cr.delete("id", id) < 1) {
            throw new RuntimeException("Cliente não foi apagado");
        }
        return true;
    }

}
