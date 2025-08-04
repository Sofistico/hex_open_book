package io.github.sofistico.hex_open_book.networking

import dev.architectury.networking.NetworkChannel
import io.github.sofistico.hex_open_book.HexOpenBook
import io.github.sofistico.hex_open_book.networking.msg.HexOpenBookMessageCompanion

object HexOpenBookNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(HexOpenBook.id("networking_channel"))

    fun init() {
        for (subclass in HexOpenBookMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
