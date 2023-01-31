package styluscar.material;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import styluscar.material.dto.CreateMaterialDto;
import styluscar.material.dto.UpdateMaterialDto;

@Mapper(componentModel = "cdi")
public interface MaterialMapper {

    MaterialMapper INSTANCE = Mappers.getMapper(MaterialMapper.class);
    public Material createMaterialDtoToMaterial (CreateMaterialDto createMaterialDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public Material updateMaterialDtoToMaterial (UpdateMaterialDto updateMaterialDto, @MappingTarget Material material);

}
