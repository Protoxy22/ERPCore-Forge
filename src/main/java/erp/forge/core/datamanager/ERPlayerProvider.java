package erp.forge.core.datamanager;

import erp.forge.core.ERPCoreForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber(modid = ERPCoreForge.MODID)
public class ERPlayerProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(IERPlayer.class)
    public static final Capability<IERPlayer> PLAYER_CAP = null;
    private final IERPlayer instance = PLAYER_CAP.getDefaultInstance();

    public static ERPlayer getERPlayer(EntityPlayer player) {
       if(player.hasCapability(PLAYER_CAP, null)){
            ERPlayer erPlayer = (ERPlayer) player.getCapability(PLAYER_CAP, null);
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
        ERPlayer erPlayer = ERPlayerProvider.getERPlayer(player);

    }

    @Override
    public NBTBase serializeNBT() {
       return PLAYER_CAP.getStorage().writeNBT(PLAYER_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        PLAYER_CAP.getStorage().readNBT(PLAYER_CAP, this.instance, null, nbt);
    }

}
