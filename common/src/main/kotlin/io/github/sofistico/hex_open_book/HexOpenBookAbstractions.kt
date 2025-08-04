@file:JvmName("HexOpenBookAbstractions")

package io.github.sofistico.hex_open_book

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.sofistico.hex_open_book.registry.HexOpenBookRegistrar

fun initRegistries(vararg registries: HexOpenBookRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HexOpenBookRegistrar<T>) {
    throw AssertionError()
}
