package styluscar.car;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
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

    public Car createCar (Car car) { //hbb0808
        Car hasCar = this.findCarById(car.getId()); //hby0809
        if (hasCar != null) {
            throw new RuntimeException("Carro já cadastrado");
        }
        this.repository.persist(car);
        return car;
    }

    public Car updateCar (Car car) {
        Car entity = this.findCarById(car.getId());
        if (entity == null) {
            throw new RuntimeException("Carro não foi encontrado");
        }

        entity.merge(car);

        this.repository.persist(entity);
        return car;
    }

    public boolean deleteCar (Long id) {
        if (this.repository.delete("id", id) < 1) {
            throw new RuntimeException("Carro não foi apagado");
        }
        return true;
    }

}
