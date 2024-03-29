package com.github.Ringoame196

import net.md_5.bungee.api.ChatMessageType
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.entity.Player

class Player(val player: Player) {
    fun sendErrorMessage(message: String) {
        player.sendMessage("${ChatColor.RED}$message")
        player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BELL, 1f, 1f)
    }
    fun sendActionBar(title: String) {
        val actionBarMessage = ChatColor.translateAlternateColorCodes('&', title)
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent(actionBarMessage))
    }
}
