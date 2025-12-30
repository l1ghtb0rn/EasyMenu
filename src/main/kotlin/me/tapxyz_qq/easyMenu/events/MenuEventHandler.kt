package me.tapxyz_qq.easyMenu.events

import me.tapxyz_qq.easyMenu.menu.Menu
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

object MenuEventHandler : Listener {

    private val users = mutableMapOf<Player, Menu>()

    @EventHandler
    fun onOpen(e: MenuOpenEvent) {
        users[e.player] = e.menu
    }

    @EventHandler
    fun onClick(e: InventoryClickEvent) {
        if (e.whoClicked !is Player || !users.contains(e.whoClicked) || users[e.whoClicked]!!.inventory != e.clickedInventory) return
        users[e.whoClicked]!!.actions[e.slot]?.invoke(e)
    }

    @EventHandler
    fun onClose(e: MenuCloseEvent) {
        users.remove(e.player)
    }

}