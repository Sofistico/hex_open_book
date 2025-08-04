package io.github.sofistico.hex_open_book.forge.mixin;

import io.github.sofistico.hex_open_book.HexOpenBook;
import org.spongepowered.asm.mixin.Mixin;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;

// scuffed workaround for https://github.com/architectury/architectury-loom/issues/189
@Mixin(net.minecraft.data.Main.class)
public class MixinDatagenMain {
    @WrapMethod(method = "main", remap = false)
    private static void hex_open_book$systemExitAfterDatagenFinishes(String[] strings, Operation<Void> original) {
        try {
            original.call((Object) strings);
        } catch (Throwable throwable) {
            HexOpenBook.LOGGER.error("Datagen failed!", throwable);
            System.exit(1);
        }
        HexOpenBook.LOGGER.info("Datagen succeeded, terminating.");
        System.exit(0);
    }
}
