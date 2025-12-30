package me.tapxyz_qq.easyMenu.menu

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

data class Button(val item: ItemStack, val event : (InventoryClickEvent) -> Unit)
