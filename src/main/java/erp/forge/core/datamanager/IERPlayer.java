package erp.forge.core.datamanager;

import net.minecraft.entity.player.EntityPlayer;

public interface IERPlayer {

    void setFirstname(String firstName);

    String getFirstname();

    void setLastname(String lastName);

    String getLastname();

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
