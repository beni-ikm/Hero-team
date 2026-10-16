package runtime.equipment.api;

import runtime.equipment.api.dto.CreateEquipmentRequest;
import runtime.equipment.application.*;

import jakarta.inject.Inject;
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


public class EquipmentResource {

    private final CreateEquipmentUseCase createEquipmentUseCase;
    private final GetEquipmentUseCase getEquipmentUseCase;
    private final CreateEquipmentRequestMapper equipmentRequestMapper;
    private final EquipmentResponseMapper equipmentResponseMapper;

    @Inject
    public EquipmentResource(
            CreateEquipmentUseCase createEquipmentUseCase,
            GetEquipmentUseCase getEquipmentUseCase,
            CreateEquipmentRequestMapper createEquipmentRequestMapper,
            EquipmentResponseMapper equipmentResponseMapper) {
        this.createEquipmentUseCase = createEquipmentUseCase;
        this.getEquipmentUseCase = getEquipmentUseCase;
        this.equipmentRequestMapper = createEquipmentRequestMapper;
        this.equipmentResponseMapper = equipmentResponseMapper;
    }

    @POST
    public Response createEquipment(
        @HeaderParam("Player-Id") @NotNull String playerId,
        @NotNull @Valid CreateEquipmentRequest request,
        @Context UriInfo uriInfo){

        CreateEquipmentCommand command = equipmentRequestMapper.toCommand(playerId,request);

        EquipmentOutPut equipment = createEquipmentUseCase.execute(command);

        URI location = uriInfo.getAbsolutePathBuilder().path(equipment.id()).build();
        return Response.created(location).build();
    }

    @GET
    @Path("{Player-Id}")
    public Response getEquipment(
            @HeaderParam("Player-Id") @NotNull String playerId,
            @PathParam("id") String equipementId){

        GetEquipmentQuery query = new GetEquipmentQuery(equipementId, playerId);
        EquipmentOutPut equipment = getEquipmentUseCase.execute(query);

        return Response.ok(equipmentResponseMapper.toResponse(equipment)).build();
    }
}
