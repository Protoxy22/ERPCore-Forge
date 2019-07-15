package erp.forge.core;

import erp.forge.core.network.PacketHandler;
import erp.forge.core.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.Logger;

@Mod(modid = ERPCoreForge.MODID, name = "erp-core-forge",version = ERPCoreForge.VERSION)
public class ERPCoreForge {

    public static final String MODID = "erp-core-forge";
	public static final String VERSION = "0.1";
    public static Logger logger;

    private SimpleNetworkWrapper erpCoreForgePacketChannel;

    @Mod.Instance
    public static ERPCoreForge instance;

    //here you must specify the path to the folder where the proxy files are located
   	@SidedProxy(serverSide = "erp.forge.core.proxy.CommonProxy")
   	public static CommonProxy proxy;


    public SimpleNetworkWrapper getPacketChannel() {
        return this.erpCoreForgePacketChannel;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        this.erpCoreForgePacketChannel = NetworkRegistry.INSTANCE.newSimpleChannel("erpcore");
        logger = event.getModLog();
        PacketHandler.init();
        proxy.preInit(event);
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
