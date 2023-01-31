
package styluscar.car;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import styluscar.car.dto.CreateCarDto;
import styluscar.car.dto.UpdateCarDto;

@Mapper(componentModel = "cdi")
public interface CarMapper {

  CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
  public Car createCarDtoToCar (CreateCarDto createCarDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  public Car updateCarDtoToCar (UpdateCarDto updateCarDto, @MappingTarget Car car);


}
