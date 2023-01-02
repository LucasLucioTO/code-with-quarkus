package styluscar.service;

import styluscar.service.dto.CreateServiceDto;
import styluscar.service.dto.UpdateServiceDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ServiceService {
    @Inject ServiceRepository sr;

    public Service findById(Long id){
        return this.sr.findById(id);
    }

    public List<Service> findAll(){
        return this.sr.listAll();
    }

    public Service createService(CreateServiceDto createServiceDto){
        Service service = new Service();
        service.buildService(createServiceDto);
        this.sr.persist(service);
        return service;
    }

    public Service updateService(UpdateServiceDto updateServiceDto){
        Service service = this.findById(updateServiceDto.getId());
        if(service == null){
            throw new RuntimeException("Serviço não encontrado.");
        }
        service.merge(updateServiceDto);
        this.sr.persist(service);
        return service;
    }

    public boolean deletedService(Long id){
        if (this.sr.delete("id",id)<1){
            throw new RuntimeException("Serviço não deletado.");
        }
        return true;
    }
}
