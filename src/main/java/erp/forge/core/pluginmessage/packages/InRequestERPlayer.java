package erp.forge.core.pluginmessage.packages;

import com.google.gson.Gson;
import erp.forge.core.pluginmessage.AbstractInPackage;

public class InRequestERPlayer extends AbstractInPackage {

    private static final int ID = 1;
    private String uuid;
    private String data;

    public InRequestERPlayer(byte[] data) {
        super(data, ID);
        readData();
    }

    private void readData() {
        this.uuid = super.getByteArrayDataInput().readUTF();
        this.data = super.getByteArrayDataInput().readUTF();
    }

    public String getName() {
        return uuid;
    }

    public String getData() {
        return data;
    }
}
