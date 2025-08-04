@file:JvmName("HexOpenBookAbstractionsImpl")

package io.github.sofistico.hex_open_book.forge

import io.github.sofistico.hex_open_book.registry.HexOpenBookRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HexOpenBookRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
