package net.dragonslayah.abyssmod.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

    @Mixin(ClientConnection.class)
    public class ClientConnectionMixin {
        @Inject(at = @At("TAIL"), method = "send(Lnet/minecraft/network/Packet;)V", cancellable = true)
        public void send(Packet<?> packet, CallbackInfo ci) {
            System.out.println(packet.getClass().getName());

        /*if(packet.getClass() == PlayerMoveC2SPacket.PositionAndOnGround.class){
            EvilMod.LOGGER.info(String.valueOf(((PlayerMoveC2SPacket.PositionAndOnGround) packet).changesPosition()));
        }*/
        }
    }
