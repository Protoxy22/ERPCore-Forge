package erp.forge.core.datamanager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ERPlayerProvider implements ICapabilityProvider {

    @CapabilityInject(IERPlayer.class)
    public static final Capability<IERPlayer> PLAYER_CAP = null;
    private final IERPlayer instance = PLAYER_CAP.getDefaultInstance();

    public static ERPlayer getERPlayer(EntityPlayer player) {
        ERPlayer erPlayer = (ERPlayer) player.getCapability(PLAYER_CAP, null);
        erPlayer.setPlayer(player);
        return erPlayer;
    }

    @Override
    public boolean hasCapability(final Capability<?> capability, final EnumFacing facing) {
        return capability == PLAYER_CAP;
    }

    @Override
    public <T> T getCapability(final Capability<T> capability, final EnumFacing facing) {
        return capability == PLAYER_CAP ? PLAYER_CAP.cast(instance) : null;
    }
}
