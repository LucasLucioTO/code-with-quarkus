package styluscar.material;


import styluscar.material.dto.CreateMaterialDto;
import styluscar.material.dto.UpdateMaterialDto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("material")
public class MaterialResource {

    @Inject
    MaterialService ms;

    @GET
    @Path("/materials")
    public List<Material> listAllMaterials(){
        try {
            return this.ms.findAllMaterial();
        } catch (Error e ) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("/create_material")
    @Transactional
    public Material createMaterial(CreateMaterialDto createMaterialDto){
        try {
            return this.ms.createMaterial(createMaterialDto);
        } catch(Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/update_material")
    @Transactional
    public Material updateMaterial(UpdateMaterialDto updateMaterialDto){
        try{
            return this.ms.updateMaterial(updateMaterialDto);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/delete_material")
    @Transactional
    public boolean deleteMaterial(Long id){
        try{
            return this.ms.deleteMaterial(id);
        }catch(Error e) {
            throw new RuntimeException(e);
        }

    }
}
