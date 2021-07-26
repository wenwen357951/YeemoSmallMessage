/*-
 * ====================LICENSE====================
 * Yeemo Build Team's Minecraft Server Plugin
 * $Id:$
 * $HeadURL:$
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
package tw.wenthink.yeemo.smallmessage.permission;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Permission Class
 *
 * @author ShengWen-Chen wenwen357951@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public enum Permission {
    /**
     * ALL
     */
    PERMISSION_STAR("*"),
    /**
     * Can use chat color
     */
    PERMISSION_CHAT_COLOR("yeemo.sms.chat.color"),
    /**
     * use tag version chat color
     */
    PERMISSION_CHAT_COLOR_TAG("yeemo.sms.chat.color.tag"),
    /**
     * use legacy version chat color
     */
    PERMISSION_CHAT_COLOR_LEGACY("yeemo.sms.chat.color.legacy");

    private final String text;

    /**
     * @param text permission node
     */
    Permission(final @NonNull String text) {
        this.text = text;
    }

    /**
     * @return permission node
     */
    @Override
    public String toString() {
        return this.text;
    }

    /**
     * format string
     *
     * @param replacements replacements
     * @return {@link String}
     */
    public String format(Object... replacements) {
        return String.format(this.toString(), replacements);
    }
}
