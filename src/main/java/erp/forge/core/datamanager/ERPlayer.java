package erp.forge.core.datamanager;


public class ERPlayer implements IERPlayer {


    private String firstname;
    private String lastname;
    private String job;
    private int money;
    private int bank;

    @Override
    public String getFirstname() {
        return this.firstname;
    }

    @Override
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String getLastname() {
        return this.lastname;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String getJob() {
        return this.job;
    }

    @Override
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public int getMoney() {
        return this.money;
    }

    @Override
    public void addMoney(int money) {
        setMoney(getMoney()+money);
    }

    @Override
    public void removeMoney(int money) {
        setMoney(getMoney()-money);
    }

    @Override
    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int getBank() {
        return this.bank;
    }

    @Override
    public void addBank(int money) {
        setMoney(getBank()+money);

    }

    @Override
    public void removeBank(int money) {
        setMoney(getBank()-money);

    }

    @Override
    public void setBank(int bank) {
        this.bank = bank;
    }
}
