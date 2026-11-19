package runtime.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import runtime.equipment.EquipmentInstaller;
import runtime.lobby.LobbyInstaller;
import runtime.player.PlayerInstaller;

public class ApplicationContext {

    private ApplicationContext() {}

    public static ResourceConfig createResourceConfig() {
        ResourceConfig resourceConfig =
                new ResourceConfig().property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        new EquipmentInstaller().install(resourceConfig);
        new PlayerInstaller().install(resourceConfig);
        new LobbyInstaller().install(resourceConfig);

        return resourceConfig;
    }
}