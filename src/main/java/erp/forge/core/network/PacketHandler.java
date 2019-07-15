package erp.forge.core.network;

import erp.forge.core.ERPCoreForge;
import erp.forge.core.network.message.MessageWhistleRequest;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    public static final SimpleNetworkWrapper INSTANCE;
    private static int nextId = 1;

    public static void init() {
        //registerMessage(XXXX.Handler.class, XXXX.class, Side.SERVER);
    }

    private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, Side side) {
        INSTANCE.registerMessage(messageHandler, requestMessageType, nextId++, side);

    }

    static {
        INSTANCE = ERPCoreForge.instance.getPacketChannel();
    }
}