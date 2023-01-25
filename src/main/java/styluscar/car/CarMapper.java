/*
 * [y] CompayZ Platform
 *
 * Copyright (c) 2022 Z COMPAY COMERCIO E SERVICOS DIGITAIS LTDA.  All rights reserved.
 *
 * This software is the confidential and proprietary information of CompayZ
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with CompayZ.
 */

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
