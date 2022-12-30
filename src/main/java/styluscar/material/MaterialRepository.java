package styluscar.material;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class MaterialRepository implements PanacheRepository<Material> {

    public Material findMaterialById(Long id){
        return this.find("id", id).firstResultOptional().orElseThrow(
                () -> new RuntimeException("Material não encontrado.")
        );

    }

}
