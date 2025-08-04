package io.github.sofistico.hex_open_book.fabric

import io.github.sofistico.hex_open_book.HexOpenBook
import net.fabricmc.api.ModInitializer

object FabricHexOpenBook : ModInitializer {
    override fun onInitialize() {
        HexOpenBook.init()
    }
}
