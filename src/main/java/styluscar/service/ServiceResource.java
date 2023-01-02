package styluscar.service;


import styluscar.service.dto.CreateServiceDto;
import styluscar.service.dto.UpdateServiceDto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("Service")
public class ServiceResource {
    @Inject
    ServiceService ss;

    @GET
    @Path("/Services")
    @Transactional
    public List<Service> listAllService(){
         try{
             return this.ss.findAll();
         } catch(Error e){
             throw new RuntimeException(e);
         }

     }
    @POST
    @Path("/create_service")
    @Transactional
    public Service createService(CreateServiceDto createServiceDto){
        try{
            return this.ss.createService(createServiceDto);
        }catch (Error e){
            throw new RuntimeException(e);
        }
     }

    @PUT
    @Path("/update_service")
    @Transactional
    public Service updateService(UpdateServiceDto updateServiceDto){
        try{
            return this.ss.updateService(updateServiceDto);
        } catch(Error e){
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/delete_service")
    @Transactional
    public boolean deleteService(Long id){
        try{
            return this.ss.deletedService(id);
        }catch(Error e){
            throw new RuntimeException(e);
        }
    }

}
