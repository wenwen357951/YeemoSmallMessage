/*-
 * ====================LICENSE====================
 * Yeemo Build Team's Minecraft Server Plugin
 * %%
 * Copyright (C) 2021 ShengWen-Chen(WenWen_xD)
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * ======================END======================
 */
package tw.wenthink.yeemo.smallmessage.listener;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import tw.wenthink.yeemo.smallmessage.YeemoSmallMessagePlugin;

/**
 * Player Chat Event Listener
 *
 * @author ShengWen-Chen wenwen357951@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public class ChatListener implements Listener {

    private final YeemoSmallMessagePlugin plugin;

    /**
     * @param plugin YeemoSmallMessagePlugin
     * @since 1.0.0
     */
    public ChatListener(YeemoSmallMessagePlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Player chat message color replacer
     *
     * @param event AsyncChatEvent
     * @since 1.0.0
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncChatEvent event) {
        String message = plugin.getAPI().serialize(event.originalMessage());
        Component originalMessage = plugin.getAPI().reparse(event.originalMessage());
        Player player = event.getPlayer();
    }
}
