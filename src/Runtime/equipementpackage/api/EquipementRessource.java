package Runtime.equipementpackage.api;

import Runtime.equipementpackage.api.dto.CreateEquipementRequest;
import Runtime.equipementpackage.application.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;

@Path("/equipement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)


public class EquipementRessource {

    private final CreateEquipementUseCase createEquipementUseCase;
    private final GetEquipementUseCase getEquipementUseCase;
    private final CreateEquipementRequestMapper equipementRequestMapper;
    private final EquipementResponseMapper equipementResponseMapper;


    public EquipementRessource(
            CreateEquipementUseCase createEquipementUseCase,
            GetEquipementUseCase getEquipementUseCase,
            CreateEquipementRequestMapper createEquipementRequestMapper,
            EquipementResponseMapper equipementResponseMapper) {
        this.createEquipementUseCase = createEquipementUseCase;
        this.getEquipementUseCase = getEquipementUseCase;
        this.equipementRequestMapper = createEquipementRequestMapper;
        this.equipementResponseMapper = equipementResponseMapper;
    }

    @POST
    public Response createEquipement(
        @HeaderParam("Player-Id") @NotNull String playerId,
        @NotNull @Valid CreateEquipementRequest request,
        @Context UriInfo uriInfo){

        CreateEquipementCommand command = equipementRequestMapper.toCommand(playerId,request);

        EquipementOutPut equipement = createEquipementUseCase.execute(command);

        URI location = uriInfo.getAbsolutePathBuilder().path(equipement.id()).build();
        return Response.created(location).build();
    }

    @GET
    @Path("{id}")
    public Response getEquipement(
            @HeaderParam("Player") @NotNull String playerId,
            @PathParam("id") String equipementId){

        GetEquipementQuery query = new GetEquipementQuery(equipementId, playerId);
        EquipementOutPut equipement = getEquipementUseCase.execute(query);

        return Response.ok(equipementResponseMapper.toResponse(equipement)).build();
    }
}
