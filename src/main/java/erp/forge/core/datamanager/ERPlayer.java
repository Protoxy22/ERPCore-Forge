package erp.forge.core.datamanager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;

public class ERPlayer implements IERPlayer {

    public static final DataParameter<String> FIRST_NAME = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.STRING);
    public static final DataParameter<String> LAST_NAME = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.STRING);

    public static final DataParameter<String> JOB = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.STRING);

    public static final DataParameter<Integer> MONEY = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> BANK = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.VARINT);


    private EntityPlayer player;


    public void setPlayer(EntityPlayer player) {
        this.player = player;
    }

    public void setFirstName(String firstName) {
        player.getDataManager().set(FIRST_NAME, firstName);
    }

    public String getFirstName() {
        return player.getDataManager().get(FIRST_NAME);
    }

    public void setLastName(String lastName) {
        player.getDataManager().set(LAST_NAME, lastName);
    }

    public String getLastName() {
        return player.getDataManager().get(LAST_NAME);
    }

    public void setJob(String jobname) {
        player.getDataManager().set(JOB, jobname);
    }

    public String getJob() {
        return player.getDataManager().get(JOB);
    }

    public void setMoney(int money) {
        player.getDataManager().set(MONEY, money);
    }

    public int getMoney() {
        return player.getDataManager().get(MONEY);
    }

    public void addMoney(int money) {
        player.getDataManager().set(MONEY, this.getMoney()+money);
    }

    public void removeMoney(int money) {
        player.getDataManager().set(MONEY, this.getMoney()-money);
    }

    public void setBank(int money) {
        player.getDataManager().set(BANK, money);
    }

    public int getBank() {
        return player.getDataManager().get(BANK);
    }

    public void addBank(int money) {
        player.getDataManager().set(BANK, this.getBank()+money);
    }

    public void removeBank(int money) {
        player.getDataManager().set(BANK, this.getBank()-money);
    }
}
