package styluscar.car;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {

    public Car findById (Long id) {
        return this.find("id", id).firstResultOptional().orElseThrow(
                () -> new RuntimeException("erro ao buscar carros"));
    }
}
