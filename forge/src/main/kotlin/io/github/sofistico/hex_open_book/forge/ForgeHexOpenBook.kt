package io.github.sofistico.hex_open_book.forge

import dev.architectury.platform.forge.EventBuses
import io.github.sofistico.hex_open_book.HexOpenBook
import net.minecraft.data.DataProvider
import net.minecraft.data.DataProvider.Factory
import net.minecraft.data.PackOutput
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(HexOpenBook.MODID)
class HexOpenBookForge {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(HexOpenBook.MODID, this)
            addListener(ForgeHexOpenBookClient::init)
            addListener(::gatherData)
        }
        HexOpenBook.init()
    }

    private fun gatherData(event: GatherDataEvent) {
        event.apply {
            // TODO: add datagen providers here
        }
    }
}

fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, Factory { factory(it) })
