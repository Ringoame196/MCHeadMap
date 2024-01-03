package com.github.Ringoame196

import com.github.Ringoame196.Commands.HeadMap
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        super.onEnable()
        getCommand("headMap")!!.setExecutor(HeadMap(this))
        saveDefaultConfig()
    }
}
