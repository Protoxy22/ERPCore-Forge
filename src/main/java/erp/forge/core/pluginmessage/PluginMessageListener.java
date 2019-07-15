package erp.forge.core.pluginmessage;


import erp.forge.core.ERPCoreForge;
import erp.forge.core.pluginmessage.event.PackageListener;
import erp.forge.core.pluginmessage.event.PackageReceiveEvent;
import erp.forge.core.pluginmessage.event.PackageSendEvent;
import erp.forge.core.pluginmessage.packages.InRequestERPlayer;

public class PluginMessageListener extends PackageListener {

    public PluginMessageListener() {
        ERPCoreForge.getPluginMessageManager().registerListener(this);
    }

    @Override
    public void onPackageReceive(PackageReceiveEvent e) {
        switch (e.getID()) {
            case 1:
                InRequestERPlayer inMGPlayerData = (InRequestERPlayer) e.getPackage();

                return;
        }

    }

    @Override
    public void onPackageSend(PackageSendEvent e) {

    }
}
