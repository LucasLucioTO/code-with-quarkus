package styluscar.order;


import styluscar.order.dto.CreateOrderDto;
import styluscar.order.dto.UpdateOrderDto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces("application/json")
@Consumes("application/json")
@Path("service")
public class OrderResource {
    @Inject
    OrderService service;

    @GET
    @Path("/services")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> listAllService(){
         try{
             return this.service.findAll();
         } catch(Error e){
             throw new RuntimeException(e);
         }

     }
    @POST
    @Path("/create_service")
    @Transactional
    public Order createService(CreateOrderDto createOrderDto){
        try{
            return this.service.createService(createOrderDto);
        }catch (Error e){
            throw new RuntimeException(e);
        }
     }

    @PUT
    @Path("/{id}")
    @Transactional
    public Order updateService(@PathParam("id") Long id, UpdateOrderDto updateOrderDto){
        try{
            return this.service.updateService(id, updateOrderDto);
        } catch(Error e){
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public boolean deleteService(@PathParam("id") Long id){
        try{
            return this.service.deletedService(id);
        }catch(Error e){
            throw new RuntimeException(e);
        }
    }

}
