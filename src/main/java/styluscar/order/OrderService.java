package styluscar.order;

import styluscar.order.dto.CreateOrderDto;
import styluscar.order.dto.UpdateOrderDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class OrderService {
    @Inject
    OrderRepository repository;

    @Inject
    OrderMapper mapper;
    public Order findById(Long id){
        return this.repository.findByIdOptional(id).orElseThrow(
                () -> new RuntimeException("erro ao buscar clientes" ));
    }

    public List<Order> findAll(){
        return this.repository.listAll();
    }

    public Order createService(CreateOrderDto createOrderDto){
        Order entity =mapper.createOrderDtoToCar(createOrderDto);
        this.repository.persist(entity);
        return entity;
    }

    public Order updateService(final Long id, final UpdateOrderDto updateOrderDto){
        Order entity = this.findById(id);
        if(entity == null){
            throw new RuntimeException("Serviço não encontrado.");
        }
        mapper.updateOrderDtoToOrder(updateOrderDto,entity);
        this.repository.persist(entity);
        return entity;
    }

    public boolean deletedService(Long id){
        if (this.repository.delete("id",id)<1){
            throw new RuntimeException("Serviço não deletado.");
        }
        return true;
    }
}
