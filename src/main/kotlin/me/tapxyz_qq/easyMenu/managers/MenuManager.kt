package me.tapxyz_qq.easyMenu.managers

import me.tapxyz_qq.easyMenu.menu.Menu
import org.bukkit.NamespacedKey
import org.bukkit.inventory.Inventory

object MenuManager {

    private val menus = mutableMapOf<NamespacedKey, Menu>()

    fun createMenu(id: NamespacedKey, size: Int) : Menu = Menu(id, size)

    fun getMenu(id: NamespacedKey) : Menu? = menus[id]

    fun Inventory.byAlreadyOpened() : Menu? {
        for (menu in menus.values) {
            if (this == menu.inventory) return menu
        }

        return null
    }

}