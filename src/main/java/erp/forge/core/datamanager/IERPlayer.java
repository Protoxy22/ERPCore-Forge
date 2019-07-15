package erp.forge.core.datamanager;

import net.minecraft.entity.player.EntityPlayer;

public interface IERPlayer {

    void setPlayer(EntityPlayer player);

    void setFirstName(String firstName);

    String getFirstName();

    void setLastName(String lastName);

    String getLastName();

    void setJob(String jobname);

    String getJob();

    void setMoney(int money);

    int getMoney();

    void addMoney(int money);

    void removeMoney(int money);

    void setBank(int money);

    int getBank();

    void addBank(int money);

    void removeBank(int money);
}
