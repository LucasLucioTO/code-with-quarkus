package styluscar.functionary;

import styluscar.functionary.dto.CreateFunctionaryDto;
import styluscar.functionary.dto.UpdateFunctionaryDto;

import javax.inject.Inject;
import java.util.List;

public class FunctionaryService {
    @Inject
    FunctionaryRepository repository;

    public Functionary findFunctionaryById(Long id){
        return this.repository.findById(id);
    }

    public List<Functionary> findAllFunctionary(){
        return this.repository.listAll();
    }

    public Functionary createFunctionary(CreateFunctionaryDto createFunctionaryDto){
        Functionary functionary = new Functionary();
        functionary.buildFunctionary(createFunctionaryDto);
        this.repository.persist(functionary);
        return functionary;
    }

    public Functionary updatefunctionary(UpdateFunctionaryDto updateFunctionaryDto){
        Functionary functionary = this.findFunctionaryById(updateFunctionaryDto.getId());
        if(functionary == null){
            throw new RuntimeException("Funcionario não encontrado.");
        }
        functionary.merge(updateFunctionaryDto);
        this.repository.persist(functionary);
        return functionary;

    }

    public boolean deleteFunctionary(Long id){
        if (this.repository.delete("id", id)<1){
            throw new RuntimeException("Funcionario não encotrado para apagar.");
        }
        return true;
    }
}
