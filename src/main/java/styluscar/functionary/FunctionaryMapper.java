package styluscar.functionary;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import styluscar.functionary.dto.CreateFunctionaryDto;
import styluscar.functionary.dto.UpdateFunctionaryDto;

@Mapper(componentModel = "cdi")
public interface FunctionaryMapper {

    FunctionaryMapper INSTANCE = Mappers.getMapper(FunctionaryMapper.class);
     public Functionary createFunctionaryDtoToFunctionary (CreateFunctionaryDto createFunctionaryDto);

     @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
     public Functionary updateFunctionaryDtotoFunctionary (UpdateFunctionaryDto updateFunctionaryDto, @MappingTarget Functionary functionary);


}
