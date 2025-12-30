package me.tapxyz_qq.easyMenu.events

import me.tapxyz_qq.easyMenu.menu.Menu
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class MenuOpenEvent(val player: Player, val menu: Menu) : Event(), Cancellable {

    companion object {

        private val handler = HandlerList()

        fun getHandlerList(): HandlerList = handler

    }

    private var cancelled = false

    override fun getHandlers(): HandlerList = handler

    override fun isCancelled(): Boolean = cancelled

    override fun setCancelled(cancel: Boolean) {
        cancelled = cancel
    }

}

class MenuCloseEvent(val player: Player, val menu: Menu) : Event() {

    companion object {

        private val handler = HandlerList()

        fun getHandlerList(): HandlerList = handler

    }

    override fun getHandlers(): HandlerList = handler

}