package styluscar.material;


import styluscar.material.dto.CreateMaterialDto;
import styluscar.material.dto.UpdateMaterialDto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("material")
public class MaterialResource {

    @Inject
    MaterialService service;

    @GET
    @Path("/materials")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Material> listAllMaterials(){
        try {
            return this.service.findAllMaterial();
        } catch (Error e ) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Transactional
    public Material createMaterial(CreateMaterialDto createMaterialDto){
        try {
            return this.service.createMaterial(createMaterialDto);
        } catch(Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Material updateMaterial(@PathParam("id") Long id,  UpdateMaterialDto updateMaterialDto){
        try{
            return this.service.updateMaterial(id, updateMaterialDto);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/delete_material")
    @Transactional
    public boolean deleteMaterial(Long id){
        try{
            return this.service.deleteMaterial(id);
        }catch(Error e) {
            throw new RuntimeException(e);
        }

    }
}
