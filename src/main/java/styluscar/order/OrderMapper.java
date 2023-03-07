package styluscar.order;


import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import styluscar.order.dto.CreateOrderDto;
import styluscar.order.dto.UpdateOrderDto;

@Mapper(componentModel = "cdi")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper((OrderMapper.class));

    public Order createOrderDtoToCar (CreateOrderDto createOrderDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public Order updateOrderDtoToOrder (UpdateOrderDto updateOrderDto, @MappingTarget Order order);

}
