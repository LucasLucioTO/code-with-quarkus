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

    @Inject ClientMapper mapper;


    public Client findClientById(Long id) {
        return this.repository.findByIdOptional(id).orElseThrow(
            () -> new RuntimeException("erro ao buscar clientes" ));
    }

    public List<Client> findAllClient() {
        return this.repository.listAll();
    }

    public Client createClient(CreateClientDto createClientDto) {
        Client entity = mapper.createClientDtoToCar(createClientDto);
        this.repository.persist(entity);
        return entity;
    }
    public Client updateClient (final Long id, final UpdateClientDto updateClientDto){
        Client entity = this.findClientById(id);
        if (entity == null){
            throw new RuntimeException("Cliente não encontrado");
        }
        mapper.updateClientDtoToClient(updateClientDto, entity);
        this.repository.persist(entity);
        return entity;

    }

    public boolean deleteClient(Long id) {
        if (this.repository.delete("id", id) < 1) {
            throw new RuntimeException("Cliente não foi apagado");
        }
        return true;
    }

}
