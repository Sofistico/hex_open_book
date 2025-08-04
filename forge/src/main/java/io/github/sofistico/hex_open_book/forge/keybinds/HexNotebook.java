package io.github.sofistico.hex_open_book.forge.keybinds;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

public class HexNotebook {
    public static final KeyMapping OPEN_HEX_BOOK = new KeyMapping("key.hex_open_book.open",
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_N, "key.categories.misc");

    // Event is on the mod event bus only on the physical client
    @SubscribeEvent
    public void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(OPEN_HEX_BOOK);
    }
}
