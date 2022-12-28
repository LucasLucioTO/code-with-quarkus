package styluscar.client;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {
    public Client findById (Long id) {
        return this.find("id", id).firstResultOptional().orElseThrow(
                () -> new RuntimeException("erro ao buscar clientes" ));
    }
}
