package styluscar.order;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;


@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {

    public Optional<Order> findServiceByIdOptional(final Long id){
        return this.find("id", id).firstResultOptional();
    }

}
