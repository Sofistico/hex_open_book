package io.github.sofistico.hex_open_book

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.sofistico.hex_open_book.config.HexOpenBookConfig
import io.github.sofistico.hex_open_book.networking.HexOpenBookNetworking
import io.github.sofistico.hex_open_book.registry.HexOpenBookActions

object HexOpenBook {
    const val MODID = "hex_open_book"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HexOpenBookConfig.init()
        initRegistries(
            HexOpenBookActions,
        )
        HexOpenBookNetworking.init()
    }
}
