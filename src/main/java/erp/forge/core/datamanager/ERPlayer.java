package erp.forge.core.datamanager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;

public class ERPlayer implements IERPlayer {


    private EntityPlayer player;


    public void setPlayer(EntityPlayer player) {
        this.player = player;
    }

    public void setFirstName(String firstName) {
        player.getDataManager().set(ERPlayerProvider.FIRST_NAME, firstName);
    }

    public String getFirstName() {
        return player.getDataManager().get(ERPlayerProvider.FIRST_NAME);
    }

    public void setLastName(String lastName) {
        player.getDataManager().set(ERPlayerProvider.LAST_NAME, lastName);
    }

    public String getLastName() {
        return player.getDataManager().get(ERPlayerProvider.LAST_NAME);
    }

    public void setJob(String jobname) {
        player.getDataManager().set(ERPlayerProvider.JOB, jobname);
    }

    public String getJob() {
        return player.getDataManager().get(ERPlayerProvider.JOB);
    }

    public void setMoney(int money) {
        player.getDataManager().set(ERPlayerProvider.MONEY, money);
    }

    public int getMoney() {
        return player.getDataManager().get(ERPlayerProvider.MONEY);
    }

    public void addMoney(int money) {
        player.getDataManager().set(ERPlayerProvider.MONEY, this.getMoney() + money);
    }

    public void removeMoney(int money) {
        player.getDataManager().set(ERPlayerProvider.MONEY, this.getMoney() - money);
    }

    public void setBank(int money) {
        player.getDataManager().set(ERPlayerProvider.BANK, money);
    }

    public int getBank() {
        return player.getDataManager().get(ERPlayerProvider.BANK);
    }

    public void addBank(int money) {
        player.getDataManager().set(ERPlayerProvider.BANK, this.getBank() + money);
    }

    public void removeBank(int money) {
        player.getDataManager().set(ERPlayerProvider.BANK, this.getBank() - money);
    }
}
