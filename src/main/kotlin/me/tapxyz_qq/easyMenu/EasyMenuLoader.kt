package me.tapxyz_qq.easyMenu

import me.tapxyz_qq.easyMenu.events.MenuEventHandler
import me.tapxyz_qq.easyMenu.events.MenuEventsCaller
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin

class EasyMenuLoader(val plugin: Plugin) {

    internal var isLoaded = false

    fun load() {
        isLoaded = true
        Bukkit.getPluginManager().registerEvents(MenuEventsCaller, plugin)
        Bukkit.getPluginManager().registerEvents(MenuEventHandler, plugin)
    }

}