package erp.forge.core.pluginmessage;

import erp.forge.core.ERPCoreForge;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;


@Mod.EventBusSubscriber(modid = ERPCoreForge.MODID)
public class Listener {

	public Listener() {
		FMLEventChannel c = NetworkRegistry.INSTANCE.newEventDrivenChannel("erpcorecom");
		c.register(this);
	}

	@SubscribeEvent
	public void onCustomServerReceive(FMLNetworkEvent.ServerCustomPacketEvent event) {
		ByteBuf buf = event.getPacket().payload();
		byte[] bytes = new byte[buf.readableBytes()];
		buf.readBytes(bytes);
		ERPCoreForge.getPluginMessageManager().receiveData(bytes);
	}


	@SubscribeEvent
	public void onCustomClientReceive(ClientCustomPacketEvent event) {
		ByteBuf buf = event.getPacket().payload();
		byte[] bytes = new byte[buf.readableBytes()];
		buf.readBytes(bytes);
		ERPCoreForge.getPluginMessageManager().receiveData(bytes);
	}
}