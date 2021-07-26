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
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import tw.wenthink.yeemo.smallmessage.YeemoSmallMessagePlugin;

/**
 * This is Yeemo SMS API Implement
 *
 * @author ShengWen-Chen wenwen357951@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public class YeemoSMSApiProvider implements YeemoSMS {

    private final YeemoSmallMessagePlugin plugin;
    private final MiniMessage miniMessage;

    public YeemoSMSApiProvider(YeemoSmallMessagePlugin plugin) {
        this.plugin = plugin;
        this.miniMessage = MiniMessage.get();
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public void broadcastSMS(String inMessage) {
        TextComponent outMessage = parseText(inMessage);
        plugin.getServer().getOnlinePlayers().forEach(player -> {
            player.sendMessage(outMessage);
        });
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public void sendSMS(Player player, String inMessage) {
        player.sendMessage(parseText(inMessage));
    }


    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public Component parse(String message) {
        return this.parse(message, false);
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public Component parse(String message, boolean useLegacy) {
        if (useLegacy) {
            return deserialize(message, true);
        }
        return this.miniMessage.parse(message);
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public TextComponent parseText(String message) {
        Component component = parse(message);
        return Component.text().append(component).build();
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public Component reparse(Component component) {
        return this.parse(serialize(component));
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public Component reparse(final Component component, ParseVersion parseVersion) {
        String original = serialize(component);
        if (parseVersion.isParseVersion(ParseVersion.NONE)) {
            return PlainTextComponentSerializer.plainText().deserialize(original);
        }

        if (parseVersion.isParseVersion(ParseVersion.BOTH)) {
            return parse(serialize(deserialize(original, true)));
        }

        return parse(original, parseVersion.isParseVersion(ParseVersion.ONLY_LEGACY));
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public String serialize(Component component) {
        return this.miniMessage.serialize(component);
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public String serialize(Component component, boolean useLegacy) {
        if (useLegacy) {
            return LegacyComponentSerializer.legacyAmpersand().serialize(component);
        }
        return this.serialize(component);
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public Component deserialize(String message) {
        return this.miniMessage.deserialize(message);
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public Component deserialize(String message, boolean useLegacy) {
        if (useLegacy) {
            return LegacyComponentSerializer.legacyAmpersand().deserialize(message);
        }
        return this.deserialize(message);
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public String getPlainText(Component component) {
        return PlainTextComponentSerializer.plainText().serialize(component);
    }

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public String getPlainText(Component component, boolean includeLegacy) {
        if (includeLegacy) {
            return getPlainText(reparse(deserialize(serialize(component), true)));
        }
        return getPlainText(component);
    }
}
