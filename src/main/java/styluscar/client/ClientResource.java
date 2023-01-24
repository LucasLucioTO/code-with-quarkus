package styluscar.client;

import styluscar.client.dto.CreateClientDto;
import styluscar.client.dto.UpdateClientDto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Endpoints relacionados aos clientes
 */
@Path("client")
public class ClientResource {
    @Inject
    ClientService service;

    @GET
    @Path("/clients")
    public List<Client> getAllClients() {
        try {
            return this.service.findAllClient();
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("/create_client")
    @Transactional
    public Client createClient(CreateClientDto createClientDto) {
        try{
            return this.service.createClient(createClientDto);
        }catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/create_client")
    @Transactional
    public Client updateClient(UpdateClientDto updateClientDto) {
        try {
            return this.service.updateClient(updateClientDto);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/delete_client")
    @Transactional
    public boolean deleteClient(Long id) {
        try {
            return this.service.deleteClient(id);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

}
