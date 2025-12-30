package me.tapxyz_qq.easyMenu.events

import me.tapxyz_qq.easyMenu.managers.MenuManager.byAlreadyOpened
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryOpenEvent

object MenuEventsCaller : Listener {

    @EventHandler
    fun castToMenuOpen(e: InventoryOpenEvent) {
        val menu = e.inventory.byAlreadyOpened()
        if (menu != null && e.player is Player) Bukkit.getPluginManager().callEvent(MenuOpenEvent(e.player as Player, menu))
    }

    @EventHandler
    fun castToMenuClose(e: InventoryCloseEvent) {
        val menu = e.inventory.byAlreadyOpened()
        if (menu != null && e.player is Player) Bukkit.getPluginManager().callEvent(MenuCloseEvent(e.player as Player, menu))
    }

}