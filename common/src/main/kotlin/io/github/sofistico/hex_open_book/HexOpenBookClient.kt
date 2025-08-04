package io.github.sofistico.hex_open_book

import io.github.sofistico.hex_open_book.config.HexOpenBookConfig
import io.github.sofistico.hex_open_book.config.HexOpenBookConfig.GlobalConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HexOpenBookClient {
    fun init() {
        HexOpenBookConfig.initClient()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(GlobalConfig::class.java, parent).get()
    }
}
