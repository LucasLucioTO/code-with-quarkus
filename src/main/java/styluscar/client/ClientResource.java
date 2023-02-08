package styluscar.client;

import styluscar.client.dto.CreateClientDto;
import styluscar.client.dto.UpdateClientDto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

/**
 * Endpoints relacionados aos clientes
 */
@Produces("application/jason")
@Consumes("application/jason")
@Path("client")
public class ClientResource {
    @Inject
    ClientService service;

    @GET
    @Path("/clients")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getAllClients() {
        try {
            return this.service.findAllClient();
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Transactional
    public Client createClient(CreateClientDto createClientDto) {
        try{
            return this.service.createClient(createClientDto);
        }catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Client updateClient(@PathParam("id") Long id, UpdateClientDto updateClientDto) {
        try {
            return this.service.updateClient(id, updateClientDto);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{id}")
    @Transactional
    public boolean deleteClient(@PathParam("id") Long id) {
        try {
            return this.service.deleteClient(id);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

}
