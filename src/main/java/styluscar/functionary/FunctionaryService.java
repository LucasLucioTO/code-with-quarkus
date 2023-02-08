package styluscar.functionary;

import styluscar.functionary.dto.CreateFunctionaryDto;
import styluscar.functionary.dto.UpdateFunctionaryDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FunctionaryService {
    @Inject
    FunctionaryRepository repository;
    @Inject FunctionaryMapper mapper;


    public Functionary findFunctionaryById(Long id){
        return this.repository.findById(id);
    }

    public List<Functionary> findAllFunctionary(){
        return this.repository.listAll();
    }

    public Functionary createFunctionary(CreateFunctionaryDto createFunctionaryDto){
        Functionary entity = mapper.createFunctionaryDtoToFunctionary(createFunctionaryDto);
        this.repository.persist(entity);
        return entity;
    }

    public Functionary updatefunctionary(final Long id, final UpdateFunctionaryDto updateFunctionaryDto){
        Functionary entity = this.findFunctionaryById(id);
        if(entity == null){
            throw new RuntimeException("Funcionario não encontrado.");
        }
        mapper.updateFunctionaryDtotoFunctionary(updateFunctionaryDto, entity);
        this.repository.persist(entity);
        return entity;

    }

    public boolean deleteFunctionary(Long id){
        if (this.repository.delete("id", id)<1){
            throw new RuntimeException("Funcionario não encotrado para apagar.");
        }
        return true;
    }
}
