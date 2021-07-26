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
package tw.wenthink.yeemo.smallmessage.api;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;
import tw.wenthink.yeemo.smallmessage.YeemoSmallMessagePlugin;

/**
 * Yeemo Small Message MC Plugin API
 *
 * <p>
 * <b>Important: You must obtain the API instance in {@link YeemoSmallMessagePlugin} before use.</b>
 * {@code YeemoSmallMessagePlugin.getInstance().getAPI()}
 * </p>
 *
 * @since 1.0.0
 */
public interface YeemoSMS {

    /**
     * Get YeemoSMS API
     *
     * @return YeemoSMS
     */
    @NonNull
    static YeemoSMS getAPI() {
        return YeemoSmallMessagePlugin.getInstance().getAPI();
    }

    /**
     * Broadcast a message to online players
     *
     * @param message Message
     * @since 1.0.0
     */
    void broadcastSMS(String message);

    /**
     * Send a message to the target online player
     *
     * @param player  Online Player
     * @param message Message
     * @since 1.0.0
     */
    void sendSMS(Player player, String message);

    /**
     * The {@link Component} parse
     *
     * @param message Message
     * @return Component
     * @see Component
     * @since 1.0.0
     */
    Component parse(String message);

    /**
     * The {@link Component} parse
     *
     * @param message   Message
     * @param useLegacy True if only the legacy version is used
     * @return Component
     * @see Component
     * @since 1.0.0
     */
    Component parse(String message, boolean useLegacy);

    /**
     * The {@link TextComponent} parse
     *
     * @param message Message
     * @return TextComponent
     * @see TextComponent
     * @since 1.0.0
     */
    TextComponent parseText(String message);

    /**
     * The {@link Component} reparse
     *
     * @param component Component
     * @return Component
     * @see Component
     * @since 1.0.0
     */
    Component reparse(Component component);

    /**
     * The {@link Component} reparse and can select ParseVersion
     *
     * <p>
     * {@link ParseVersion} is the method version to color everything.
     * </p>
     *
     * @param component    Component
     * @param parseVersion Parse Version
     * @return Component
     * @see ParseVersion
     * @see Component
     * @since 1.0.0
     */
    Component reparse(Component component, ParseVersion parseVersion);

    /**
     * @param component Component
     * @return String
     * @see <a href="https://docs.adventure.kyori.net/minimessage.html#api">API</a>
     * @since 1.0.0
     */
    String serialize(Component component);

    /**
     * @param component Component
     * @param useLegacy True if only the legacy version is used
     * @return String
     * @see <a href="https://docs.adventure.kyori.net/minimessage.html#api">API</a>
     * @since 1.0.0
     */
    String serialize(Component component, boolean useLegacy);

    /**
     * @param message Message
     * @return Component
     * @see <a href="https://docs.adventure.kyori.net/minimessage.html#api">API</a>
     * @since 1.0.0
     */
    Component deserialize(String message);

    /**
     * @param message   Message
     * @param useLegacy True if only the legacy version is used
     * @return Component
     * @see <a href="https://docs.adventure.kyori.net/serializer/legacy.html">LegacyComponentSerializer</a>
     * @since 1.0.0
     */
    Component deserialize(String message, boolean useLegacy);

    /**
     * @param component Component
     * @return String
     * @see <a href="https://docs.adventure.kyori.net/serializer/plain.html">PlainTextComponentSerializer</a>
     * @since 1.0.0
     */
    String getPlainText(Component component);

    /**
     * @param component     Component
     * @param includeLegacy True if want include legacy version is used
     * @return String
     * @see <a href="https://docs.adventure.kyori.net/serializer/plain.html">PlainTextComponentSerializer</a>
     * @since 1.0.0
     */
    String getPlainText(Component component, boolean includeLegacy);
}
