package styluscar.functionary;

import styluscar.functionary.dto.CreateFunctionaryDto;
import styluscar.functionary.dto.UpdateFunctionaryDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FunctionaryService {
    @Inject
    FunctionaryRepository fr;

    public Functionary findFunctionaryById(Long id){
        return this.fr.findById(id);
    }

    public List<Functionary> findAllFunctionary(){
        return this.fr.listAll();
    }

    public Functionary createFunctionary(CreateFunctionaryDto createFunctionaryDto){
        Functionary functionary = new Functionary();
        functionary.buildFunctionary(createFunctionaryDto);
        this.fr.persist(functionary);
        return functionary;
    }

    public Functionary updatefunctionary(UpdateFunctionaryDto updateFunctionaryDto){
        Functionary functionary = this.findFunctionaryById(updateFunctionaryDto.getId());
        if(functionary == null){
            throw new RuntimeException("Funcionario não encontrado.");
        }
        functionary.merge(updateFunctionaryDto);
        this.fr.persist(functionary);
        return functionary;

    }

    public boolean deleteFunctionary(Long id){
        if (this.fr.delete("id", id)<1){
            throw new RuntimeException("Funcionario não encotrado para apagar.");
        }
        return true;
    }
}
