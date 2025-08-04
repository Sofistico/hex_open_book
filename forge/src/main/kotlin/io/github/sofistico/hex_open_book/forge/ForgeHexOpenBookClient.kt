package io.github.sofistico.hex_open_book.forge

import io.github.sofistico.hex_open_book.HexOpenBookClient
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

object ForgeHexOpenBookClient {
    fun init(event: FMLClientSetupEvent) {
        HexOpenBookClient.init()
        LOADING_CONTEXT.registerExtensionPoint(ConfigScreenFactory::class.java) {
            ConfigScreenFactory { _, parent -> HexOpenBookClient.getConfigScreen(parent) }
        }
    }
}
