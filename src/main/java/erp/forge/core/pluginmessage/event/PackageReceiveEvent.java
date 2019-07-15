package erp.forge.core.pluginmessage.event;


import erp.forge.core.pluginmessage.AbstractInPackage;

public class PackageReceiveEvent {

	boolean isCancelled;
	AbstractInPackage pack;
	int id;

	public PackageReceiveEvent(AbstractInPackage a) {
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

	public AbstractInPackage getPackage() {return pack;}

}
