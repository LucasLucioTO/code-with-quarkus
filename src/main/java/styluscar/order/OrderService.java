package styluscar.order;

import styluscar.order.dto.CreateOrderDto;
import styluscar.order.dto.UpdateOrderDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class OrderService {
    @Inject
    OrderRepository sr;

    public Order findById(Long id){
        return this.sr.findById(id);
    }

    public List<Order> findAll(){
        return this.sr.listAll();
    }

    public Order createService(CreateOrderDto createOrderDto){
        Order order = new Order();
        order.buildService(createOrderDto);
        this.sr.persist(order);
        return order;
    }

    public Order updateService(UpdateOrderDto updateOrderDto){
        Order order = this.findById(updateOrderDto.getId());
        if(order == null){
            throw new RuntimeException("Serviço não encontrado.");
        }
        order.merge(updateOrderDto);
        this.sr.persist(order);
        return order;
    }

    public boolean deletedService(Long id){
        if (this.sr.delete("id",id)<1){
            throw new RuntimeException("Serviço não deletado.");
        }
        return true;
    }
}
