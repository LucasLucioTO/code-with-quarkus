package styluscar.functionary;


import styluscar.functionary.dto.CreateFunctionaryDto;
import styluscar.functionary.dto.UpdateFunctionaryDto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("functionary")
public class FunctionaryResource {
    @Inject
    FunctionaryService service;

    @GET
    @Path("/functionarys")
    public List<Functionary> getAllFunctionarys() {
        try{
            return this.service.findAllFunctionary();
        } catch (Error e){
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("/create_functionary")
    @Transactional
    public Functionary createFunctionary(CreateFunctionaryDto createFunctionaryDto){
        try{
            return this.service.createFunctionary(createFunctionaryDto);
        }catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/update_functionary")
    @Transactional
    public Functionary updateFunctionary(UpdateFunctionaryDto updateFunctionaryDto){
        try {
            return this.service.updatefunctionary(updateFunctionaryDto);
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
