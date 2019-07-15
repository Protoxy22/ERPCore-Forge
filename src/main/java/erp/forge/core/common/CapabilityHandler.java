package erp.forge.core.common;

import erp.forge.core.ERPCoreForge;
import erp.forge.core.datamanager.ERPlayerProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid = ERPCoreForge.MODID)
public class CapabilityHandler {

    public static final ResourceLocation ERPLAYER_CAP = new ResourceLocation(ERPCoreForge.MODID + ":" + "erp_profile");

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void attachCapability(final AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(ERPLAYER_CAP, new ERPlayerProvider());
        }
    }

}
