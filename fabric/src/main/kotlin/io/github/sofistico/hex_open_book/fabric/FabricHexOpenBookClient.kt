package io.github.sofistico.hex_open_book.fabric

import io.github.sofistico.hex_open_book.HexOpenBookClient
import net.fabricmc.api.ClientModInitializer

object FabricHexOpenBookClient : ClientModInitializer {
    override fun onInitializeClient() {
        HexOpenBookClient.init()
    }
}
