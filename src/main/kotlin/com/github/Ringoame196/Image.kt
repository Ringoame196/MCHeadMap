package com.github.Ringoame196

import org.bukkit.OfflinePlayer
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.awt.image.BufferedImage
import java.io.File
import java.net.URL
import javax.imageio.ImageIO

class Image {
    fun downloadImage(targetPlayer: OfflinePlayer, plugin: Plugin): BufferedImage? {
        val url = acquisitionDownloadURL(targetPlayer, plugin)
        return try {
            ImageIO.read(URL(url))
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    private fun acquisitionConfig(plugin: Plugin): YamlConfiguration {
        val configFile = File(plugin.dataFolder, "config.yml")
        return YamlConfiguration.loadConfiguration(configFile)
    }
    private fun acquisitionDownloadURL(targetPlayer: OfflinePlayer, plugin: Plugin): String {
        val playerName = targetPlayer.name
        val uuid = targetPlayer.uniqueId.toString()
        var url = acquisitionConfig(plugin).getString("HeadURL") ?: throw RuntimeException("URLが取得できませんでした")
        url = url.replace("{PlayerName}", playerName.toString())
        url = url.replace("{PlayerUUID}", uuid)
        return url
    }
    fun resizeImage(originalImage: BufferedImage?, width: Int, height: Int): BufferedImage {
        val resizedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
        val g = resizedImage.createGraphics()
        g.drawImage(originalImage, 0, 0, width, height, null)
        g.dispose()
        return resizedImage
    }
}
