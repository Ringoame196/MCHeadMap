package com.github.Ringoame196.Commands

import com.github.Ringoame196.Map
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

class HeadMap(private val plugin: Plugin) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) { return false }
        if (args.isEmpty()) { return false }
        val playerClass = com.github.Ringoame196.Player(sender)
        val targetPlayerName = args[0]
        playerClass.sendActionBar("${ChatColor.GOLD}画像生成中...")
        sender.playSound(sender, Sound.BLOCK_ANVIL_USE, 1f, 1f)
        sender.inventory.addItem(Map().makeMap(targetPlayerName, sender, plugin))
        return true
    }
}
