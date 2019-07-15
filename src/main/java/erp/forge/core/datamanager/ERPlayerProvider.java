package erp.forge.core.datamanager;

import erp.forge.core.ERPCoreForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber(modid = ERPCoreForge.MODID)
public class ERPlayerProvider implements ICapabilityProvider {

    public static final DataParameter<String> FIRST_NAME = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.STRING);
    public static final DataParameter<String> LAST_NAME = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.STRING);

    public static final DataParameter<String> JOB = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.STRING);

    public static final DataParameter<Integer> MONEY = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> BANK = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.VARINT);


    @CapabilityInject(IERPlayer.class)
    public static final Capability<IERPlayer> PLAYER_CAP = null;
    private final IERPlayer instance = PLAYER_CAP.getDefaultInstance();

    public static ERPlayer getERPlayer(EntityPlayer player) {
       if(player.hasCapability(PLAYER_CAP, null)){
            ERPlayer erPlayer = (ERPlayer) player.getCapability(PLAYER_CAP, null);
            erPlayer.setPlayer(player);
            return erPlayer;
        }
        return null;
    }

    @Override
    public boolean hasCapability(final Capability<?> capability, final EnumFacing facing) {
        return capability == PLAYER_CAP;
    }

    @Override
    public <T> T getCapability(final Capability<T> capability, final EnumFacing facing) {
        return capability == PLAYER_CAP ? PLAYER_CAP.cast(instance) : null;
    }


    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void playerLoggedIn(final PlayerEvent.PlayerLoggedInEvent event) {
        final EntityPlayerMP player = (EntityPlayerMP) event.player;
        ERPlayer mythriaPlayer = ERPlayerProvider.getERPlayer(player);
        mythriaPlayer.setPlayer(player);
    }

    @SubscribeEvent
    public static void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if (event.getEntity() instanceof EntityPlayer) {
            ERPCoreForge.logger.info("Player constructing...");
            EntityPlayer player = (EntityPlayer) event.getEntity();

            player.getDataManager().register(FIRST_NAME, "");
            player.getDataManager().register(LAST_NAME, "");
            player.getDataManager().register(JOB, "");
            player.getDataManager().register(MONEY, 0);
            player.getDataManager().register(BANK, 0);
        }
    }

}
