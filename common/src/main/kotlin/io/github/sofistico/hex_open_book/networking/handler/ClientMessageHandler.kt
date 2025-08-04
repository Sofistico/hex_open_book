package io.github.sofistico.hex_open_book.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.sofistico.hex_open_book.config.HexOpenBookConfig
import io.github.sofistico.hex_open_book.networking.msg.*

fun HexOpenBookMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            HexOpenBookConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
