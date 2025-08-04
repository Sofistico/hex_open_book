package io.github.sofistico.hex_open_book.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.sofistico.hex_open_book.HexOpenBook
import io.github.sofistico.hex_open_book.networking.HexOpenBookNetworking
import io.github.sofistico.hex_open_book.networking.handler.applyOnClient
import io.github.sofistico.hex_open_book.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface HexOpenBookMessage

sealed interface HexOpenBookMessageC2S : HexOpenBookMessage {
    fun sendToServer() {
        HexOpenBookNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HexOpenBookMessageS2C : HexOpenBookMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HexOpenBookNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HexOpenBookNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HexOpenBookMessageCompanion<T : HexOpenBookMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                HexOpenBook.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is HexOpenBookMessageC2S -> msg.applyOnServer(ctx)
                    else -> HexOpenBook.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                HexOpenBook.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HexOpenBookMessageS2C -> msg.applyOnClient(ctx)
                    else -> HexOpenBook.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
