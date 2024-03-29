package styluscar.car;

import styluscar.car.dto.CreateCarDto;
import styluscar.car.dto.UpdateCarDto;
import styluscar.client.Client;
import styluscar.client.ClientRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CarService {
    @Inject CarRepository repository;

    @Inject CarMapper mapper;

    @Inject ClientRepository clientRepository;

    public Car findCarById (Long id) {
        return this.repository.findById(id);
    }

    public List<Car> findAllCars () {
        return this.repository.listAll();
    }

    public Car createCar (CreateCarDto createCarDto) {
        Car entity = mapper.createCarDtoToCar(createCarDto);

        Client client = this.clientRepository.findByIdOptional(createCarDto.getClientId()).orElseThrow(
            () -> new RuntimeException("Cliente não encontrado"));

        entity.setClient(client);

        this.repository.persist(entity);
        return entity;
    }

    public Car updateCar (final Long id, final UpdateCarDto carDto) {
        Car entity = this.findCarById(id);
        if (entity == null) {
            throw new RuntimeException("Carro não foi encontrado");
        }

        mapper.updateCarDtoToCar(carDto, entity);

        this.repository.persist(entity);
        return entity;
    }

    public boolean deleteCar (Long id) {
        if (this.repository.delete("id", id) < 1) {
            throw new RuntimeException("Carro não foi apagado");
        }
        return true;
    }

}
