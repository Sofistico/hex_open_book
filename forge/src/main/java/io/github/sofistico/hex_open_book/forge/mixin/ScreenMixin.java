package io.github.sofistico.hex_open_book.forge.mixin;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.sofistico.hex_open_book.forge.keybinds.HexNotebook;

import at.petrak.hexcasting.client.gui.GuiSpellcasting;
import vazkii.patchouli.api.PatchouliAPI;
import vazkii.patchouli.client.book.gui.GuiBook;

@Mixin(Screen.class)
public class ScreenMixin {
  private static GuiSpellcasting storedHexScreen;

  @Inject(method = "keyPressed", at = @At("HEAD"), cancellable = true)
  public void checkForOpenBook(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir){
    if(((Object) this) instanceof GuiSpellcasting castingScreen){
      if(HexNotebook.OPEN_HEX_BOOK.matches(keyCode, scanCode)){
        storedHexScreen = castingScreen;
        PatchouliAPI.get().openBookGUI(new ResourceLocation("hexcasting", "thehexbook"));
      }
    }
  }

  @Inject(method = "onClose", at = @At("HEAD"), cancellable = true)
  public void returnToStaff(CallbackInfo ci)
  {
    if(((Object)this) instanceof GuiBook bookScreen && storedHexScreen != null){
      Minecraft.getInstance().setScreen(storedHexScreen);
      storedHexScreen = null;
      ci.cancel();
    }
  }
}
