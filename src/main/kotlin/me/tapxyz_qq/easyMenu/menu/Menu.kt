package me.tapxyz_qq.easyMenu.menu

import me.tapxyz_qq.easyMenu.events.MenuOpenEvent
import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack
import kotlin.math.roundToInt

class Menu internal constructor(val id: NamespacedKey, size: Int){

    companion object {
        fun Player.openMenu(menu: Menu) {
            this.openInventory(menu.inventory)
            Bukkit.getPluginManager().callEvent(MenuOpenEvent(this, menu))
        }
    }

    internal val inventory = Bukkit.createInventory(null, (size.toFloat()/9.0f).roundToInt() * 9)
    private val size = inventory.size

    internal val actions : MutableMap<Int, (InventoryClickEvent) -> Unit> = mutableMapOf()

    fun setButton(slot: Int, button: Button) {
        if (slot !in 0 until size) {
            throw IllegalArgumentException("Slot can't be less than 0 or higher than inventory size($size)")
        }

        inventory.setItem(slot, button.item)
        actions[slot] = button.event
    }

    fun removeButton(slot: Int) {
        inventory.setItem(slot, null)
        actions.remove(slot)
    }

    fun setItem(slot: Int, item: ItemStack) {
        inventory.setItem(slot, item)
    }
}