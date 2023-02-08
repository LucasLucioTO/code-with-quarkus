package styluscar.client;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import styluscar.client.dto.CreateClientDto;
import styluscar.client.dto.UpdateClientDto;

@Mapper(componentModel ="cdi")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper((ClientMapper.class));

    public Client createClientDtotoCar (CreateClientDto createClientDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public Client updateClientDtoToClient (UpdateClientDto updateClientDto,@MappingTarget Client client);


}
