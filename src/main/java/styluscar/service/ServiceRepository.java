package styluscar.service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ServiceRepository implements PanacheRepository<Service> {

    public Service findServiceById(Long id){
        return this.find("id", id).firstResultOptional().orElseThrow(
                () -> new RuntimeException("Serviço não encontrado.")
        );
    }

}
