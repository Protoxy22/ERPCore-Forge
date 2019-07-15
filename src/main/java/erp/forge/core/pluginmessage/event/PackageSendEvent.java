package erp.forge.core.pluginmessage.event;


import erp.forge.core.pluginmessage.AbstractOutPackage;

public class PackageSendEvent {
	boolean isCancelled;
	AbstractOutPackage pack;
	int id;

	public PackageSendEvent(AbstractOutPackage a) {
		this.pack = a;
		this.id = a.getID();
	}

	public void setCancelled(boolean arg) {
		this.isCancelled = arg;
	}

	public boolean isCancelled() {
		return this.isCancelled;
	}

	public int getID() {
		return this.id;
	}

	public AbstractOutPackage getPackage() {
		return pack;
	}

}
