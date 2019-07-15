package erp.forge.core.datamanager;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ERPlayerDataStorage implements IStorage<IERPlayer> {
    @Override
    public NBTBase writeNBT(final Capability<IERPlayer> capability, final IERPlayer instance, final EnumFacing side) {
        return new NBTTagCompound();
    }

    @Override
    public void readNBT(final Capability<IERPlayer> capability, final IERPlayer instance, final EnumFacing side, final NBTBase nbt) {
    }
}
