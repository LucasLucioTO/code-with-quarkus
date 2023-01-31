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
    @Inject MaterialMapper mapper;

    public Material findById(Long id){
        return this.repository.findById(id);
    }

    public List<Material> findAllMaterial(){
        return this.repository.listAll();
    }

    public Material createMaterial(CreateMaterialDto createMaterialDto){
        Material entity = mapper.createMaterialDtoToMaterial(createMaterialDto);
        this.repository.persist(entity);
        return entity;
    }

    public Material updateMaterial(final Long id, final UpdateMaterialDto updateMaterialDto){
        Material entity = this.findById(id);
        if (entity == null){
            throw new RuntimeException("Material não encontrado.");
        }
        mapper.updateMaterialDtoToMaterial(updateMaterialDto, entity);
        this.repository.persist(entity);
        return entity;
    }

    public boolean deleteMaterial(Long id){
        if (this.repository.delete("id",id)<1){
            throw new RuntimeException("Material não foi encontrado para apagar.");
        }
        return true;
    }
}
