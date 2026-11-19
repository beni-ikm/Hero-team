package runtime.player.api;

import runtime.player.api.dto.CreatePlayerRequest;
import runtime.player.application.CreatePlayerCommand;

public class CreatePlayerRequestMapper {

    public CreatePlayerCommand toCommand(String userId, CreatePlayerRequest request) {
        return new CreatePlayerCommand(
                userId,
                request.pseudonym(),
                request.email().value(),
                request.password().value());
    }

}
