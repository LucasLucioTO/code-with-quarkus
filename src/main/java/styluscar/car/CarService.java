package styluscar.car;

import styluscar.car.dto.CreateCarDto;
import styluscar.car.dto.UpdateCarDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CarService {
    @Inject CarRepository repository;

    public Car findCarById (Long id) {
        return this.repository.findById(id);
    }

    public List<Car> findAllCars () {
        return this.repository.listAll();
    }

    public Car createCar (CreateCarDto createCarDto) { //hbb0808
        Car entity = new Car();
        entity.buildCar(createCarDto);
        this.repository.persist(entity);
        return entity;
    }

    public Car updateCar (UpdateCarDto carDto) {
        Car entity = this.findCarById(carDto.getId());
        if (entity == null) {
            throw new RuntimeException("Carro não foi encontrado");
        }

        entity.merge(carDto);

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
