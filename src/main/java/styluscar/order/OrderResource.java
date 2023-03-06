package styluscar.order;


import styluscar.order.dto.CreateOrderDto;
import styluscar.order.dto.UpdateOrderDto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Produces("/")
@Path("service")
public class OrderResource {
    @Inject
    OrderService service;

    @GET
    @Path("/services")
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
    @Path("/update_service")
    @Transactional
    public Order updateService(UpdateOrderDto updateOrderDto){
        try{
            return this.service.updateService(updateOrderDto);
        } catch(Error e){
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/delete_service")
    @Transactional
    public boolean deleteService(Long id){
        try{
            return this.service.deletedService(id);
        }catch(Error e){
            throw new RuntimeException(e);
        }
    }

}
