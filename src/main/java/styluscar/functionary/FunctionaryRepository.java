package styluscar.functionary;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FunctionaryRepository implements PanacheRepository<Functionary> {
    public Functionary findById(Long id) {
        return this.find("id", id).firstResultOptional().orElseThrow(
                () -> new RuntimeException("Erro ao buscar funcionario."));
    }


}
