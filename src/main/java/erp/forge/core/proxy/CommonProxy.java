package erp.forge.core.proxy;

import erp.forge.core.common.CommonEvents;
import erp.forge.core.datamanager.ERPlayer;
import erp.forge.core.datamanager.ERPlayerDataStorage;
import erp.forge.core.datamanager.IERPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        CapabilityManager.INSTANCE.register(IERPlayer.class, new ERPlayerDataStorage(), ERPlayer.class);

        MinecraftForge.EVENT_BUS.register(new CommonEvents());
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {}


}
