package styluscar.client;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {
    public Optional<Client> findByIdOptional (final Long id) {
        return this.find("id", id).firstResultOptional();
    }
}
