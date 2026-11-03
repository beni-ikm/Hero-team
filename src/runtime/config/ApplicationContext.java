package runtime.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import runtime.equipment.EquipmentInstaller;

public class ApplicationContext {

    private ApplicationContext(){}

    public static ResourceConfig createResourceConfig(){

        ResourceConfig resourceConfig =
                new ResourceConfig().property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        EquipmentInstaller equipmentInstaller = new EquipmentInstaller();
        equipmentInstaller.install(resourceConfig);

        return resourceConfig;
    }
}
