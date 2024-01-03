package com.github.Ringoame196

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.MapMeta
import org.bukkit.map.MapView
import org.bukkit.plugin.Plugin

class Map {
    fun makeMap(targetPlayerName: String, player: Player, plugin: Plugin): ItemStack {
        val map = ItemStack(Material.FILLED_MAP)
        val meta = map.itemMeta as MapMeta
        val targetPlayer = Bukkit.getOfflinePlayer(targetPlayerName)
        val mapView = Bukkit.createMap(player.world)
        pasteMap(mapView)
        pasteImage(mapView, targetPlayer, plugin)
        meta.setDisplayName("${ChatColor.GOLD}${targetPlayer.name}の頭")
        meta.mapView = mapView
        map.setItemMeta(meta)
        return map
    }
    private fun pasteImage(mapView: MapView, targetPlayer: OfflinePlayer, plugin: Plugin): MapView {
        val image = Image()
        val downLoadImage = image.downloadImage(targetPlayer, plugin)
        val size = 128
        val resizedImage = image.resizeImage(downLoadImage, size, size)
        mapView.addRenderer(ImageRenderer(resizedImage))
        return mapView
    }
    private fun pasteMap(mapView: MapView): MapView {
        mapView.renderers.clear()
        mapView.scale = MapView.Scale.FARTHEST
        return mapView
    }
}
