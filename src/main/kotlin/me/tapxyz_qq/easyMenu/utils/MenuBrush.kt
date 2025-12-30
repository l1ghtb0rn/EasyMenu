package me.tapxyz_qq.easyMenu.utils

import me.tapxyz_qq.easyMenu.menu.Button
import me.tapxyz_qq.easyMenu.menu.Menu
import org.bukkit.inventory.ItemStack

object MenuBrush {

    fun Menu.clear() {
        this.inventory.clear()
        this.actions.clear()
    }

    fun Menu.fillBackground(item: ItemStack) {
        this.inventory.contents.forEachIndexed { index, _ ->
            if (index !in this.actions.keys) {
                inventory.setItem(index, item)
            }
        }
    }

    fun Menu.setItem(slot: Int, item: ItemStack) {
        this.inventory.setItem(slot, item)
    }

    fun Menu.fillSlots(item: ItemStack, range: IntRange) {
        this.inventory.contents.forEachIndexed { index, _ ->
            if (index in range) {
                this.setItem(index, item)
            }
        }
    }

    fun Menu.fillButtons(button: Button, range: IntRange) {
        this.inventory.contents.forEachIndexed { index, _ ->
            if (index in range) {
                this.setButton(index, button)
            }
        }
    }

}