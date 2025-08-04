package io.github.sofistico.hex_open_book.networking.msg

import io.github.sofistico.hex_open_book.config.HexOpenBookConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: HexOpenBookConfig.ServerConfig) : HexOpenBookMessageS2C {
    companion object : HexOpenBookMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) = MsgSyncConfigS2C(
            serverConfig = HexOpenBookConfig.ServerConfig.decode(buf),
        )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
