package net.dragonslayah.abyssmod;

import net.dragonslayah.abyssmod.exploits.Fly;
import net.dragonslayah.abyssmod.exploits.Teleport;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class AbyssModClient implements ClientModInitializer {
    public static final MinecraftClient mc = MinecraftClient.getInstance();
    private static final String CATEGORY = AbyssMod.MOD_ID + ".key_category";
    private static final KeyBinding keyBindingX = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            AbyssMod.MOD_ID+".x",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_X,
            CATEGORY
    ));

    private static final KeyBinding keyBindingU = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            AbyssMod.MOD_ID+".u",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_U,
            CATEGORY
    ));
    private static final KeyBinding keyBindingSpace = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            AbyssMod.MOD_ID+".space",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_Z,
            CATEGORY
    ));

    @Override
    public void onInitializeClient() {
            ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Fly fly = new Fly();
            fly.vehicleFly(client);
            fly.fly(client);
        });
            Teleport.registerKeybinding();  // Register keybinds
            ClientTickEvents.END_CLIENT_TICK.register(Teleport::checkKeybindings);  // Register a function to be called every tick
    }
}
