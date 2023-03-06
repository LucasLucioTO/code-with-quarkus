package styluscar.order;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {

    public Order findServiceById(Long id){
        return this.find("id", id).firstResultOptional().orElseThrow(
                () -> new RuntimeException("Serviço não encontrado.")
        );
    }

}
