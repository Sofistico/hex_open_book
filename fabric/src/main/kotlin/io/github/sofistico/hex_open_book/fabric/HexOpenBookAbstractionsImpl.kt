@file:JvmName("HexOpenBookAbstractionsImpl")

package io.github.sofistico.hex_open_book.fabric

import io.github.sofistico.hex_open_book.registry.HexOpenBookRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HexOpenBookRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
