package styluscar.material;

import styluscar.material.dto.CreateMaterialDto;
import styluscar.material.dto.UpdateMaterialDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MaterialService {
    @Inject
    MaterialRepository repository;

    public Material findById(Long id){
        return this.repository.findById(id);
    }

    public List<Material> findAllMaterial(){
        return this.repository.listAll();
    }

    public Material createMaterial(CreateMaterialDto createMaterialDto){
        Material material =new Material();
        material.buildMaterial(createMaterialDto);
        this.repository.persist(material);
        return material;
    }

    public Material updateMaterial(UpdateMaterialDto updateMaterialDto){
        Material material = this.findById(updateMaterialDto.getId());
        if (material == null){
            throw new RuntimeException("Material não encontrado.");
        }
        material.merge(updateMaterialDto);
        this.repository.persist(material);
        return material;
    }

    public boolean deleteMaterial(Long id){
        if (this.repository.delete("id",id)<1){
            throw new RuntimeException("Material não foi encontrado para apagar.");
        }
        return true;
    }
}
