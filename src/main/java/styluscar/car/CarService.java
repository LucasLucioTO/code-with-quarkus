package styluscar.car;

import styluscar.car.dto.CreateCarDto;
import styluscar.car.dto.UpdateCarDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CarService {
    @Inject CarRepository cr;

    public Car findCarById (Long id) {
        return this.cr.findById(id);
    }

    public List<Car> findAllCars () {
        return this.cr.listAll();
    }

    public Car createCar (CreateCarDto createCarDto) {
        Car entity = new Car();
        entity.buildCar(createCarDto);
        this.cr.persist(entity);
        return entity;
    }

    public Car updateCar (UpdateCarDto carDto) {
        Car entity = this.findCarById(carDto.getId());
        if (entity == null) {
            throw new RuntimeException("Carro não foi encontrado");
        }

        entity.merge(carDto);

        this.cr.persist(entity);
        return entity;
    }

    public boolean deleteCar (Long id) {
        if (this.cr.delete("id", id) < 1) {
            throw new RuntimeException("Carro não foi apagado");
        }
        return true;
    }

}
