package io.github.sofistico.hex_open_book.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.sofistico.hex_open_book.HexOpenBookClient

object FabricHexOpenBookModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HexOpenBookClient::getConfigScreen)
}
