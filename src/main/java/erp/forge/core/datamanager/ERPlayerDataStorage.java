package erp.forge.core.datamanager;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ERPlayerDataStorage implements IStorage<IERPlayer> {

    @Override
    public NBTBase writeNBT(final Capability<IERPlayer> capability, final IERPlayer instance, final EnumFacing side) {
        NBTTagCompound c = new NBTTagCompound();
        c.setString("firstname", instance.getFirstname());
        c.setString("lastname", instance.getLastname());
        c.setString("job", instance.getJob());
        c.setInteger("money", instance.getMoney());
        c.setInteger("bank", instance.getBank());
        return c;
    }

    @Override
    public void readNBT(final Capability<IERPlayer> capability, final IERPlayer instance, final EnumFacing side, final NBTBase nbt) {
        instance.setFirstname(((NBTTagCompound)nbt).getString("firstname"));
        instance.setLastname(((NBTTagCompound)nbt).getString("lastname"));
        instance.setJob(((NBTTagCompound)nbt).getString("job"));
        instance.setMoney(((NBTTagCompound)nbt).getInteger("money"));
        instance.setBank(((NBTTagCompound)nbt).getInteger("bank"));
    }
}
