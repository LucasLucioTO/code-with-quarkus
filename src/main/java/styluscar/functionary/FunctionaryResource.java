package styluscar.functionary;


import styluscar.functionary.dto.CreateFunctionaryDto;
import styluscar.functionary.dto.UpdateFunctionaryDto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Produces("application/json")
@Consumes("application/json")
@Path("/functionary")
public class FunctionaryResource {
    @Inject
    FunctionaryService service;

    @GET
    @Path("/functionarys")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Functionary> getAllFunctionarys() {
        try{
            List<Functionary> functionarys = this.service.findAllFunctionary();
            return functionarys;
        } catch (Error e){
            throw new RuntimeException(e);
        }
    }

    @POST
    @Transactional
    public Functionary createFunctionary(CreateFunctionaryDto createFunctionaryDto){
        try{
            return this.service.createFunctionary(createFunctionaryDto);
        }catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Functionary updateFunctionary(@PathParam("id") Long id, UpdateFunctionaryDto updateFunctionaryDto){
        try {
            return this.service.updatefunctionary(id, updateFunctionaryDto);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/delete_functionary")
    @Transactional
    public boolean deleteFunctionary(long id){
        try {
            return this.service.deleteFunctionary(id);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }
}
