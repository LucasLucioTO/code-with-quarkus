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
    ClientService cs;

    @GET
    @Path("/clients")
    public List<Client> getAllClients() {
        try {
            return this.cs.findAllClient();
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("/create_client")
    @Transactional
    public Client createClient(CreateClientDto createClientDto) {
        try{
            return this.cs.createClient(createClientDto);
        }catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/create_client")
    @Transactional
    public Client updateClient(UpdateClientDto updateClientDto) {
        try {
            return this.cs.updateClient(updateClientDto);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/delete_client")
    @Transactional
    public boolean deleteClient(Long id) {
        try {
            return this.cs.deleteClient(id);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

}
