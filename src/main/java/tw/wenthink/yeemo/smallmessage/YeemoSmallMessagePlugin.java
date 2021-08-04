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

package tw.wenthink.yeemo.smallmessage;

import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import tw.wenthink.yeemo.smallmessage.api.YeemoSMS;
import tw.wenthink.yeemo.smallmessage.api.YeemoSMSApiProvider;
import tw.wenthink.yeemo.smallmessage.listener.ChatListener;

/**
 * Yeemo Small Message Plugin Main Class
 *
 * <p>
 * Yeemo small message aka <b>YeemoSMS</b>.
 * This plugin is make for yeemo build team server!
 * </p>
 *
 * @author ShengWen-Chen wenwen357951@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public final class YeemoSmallMessagePlugin extends JavaPlugin {

    @NonNull
    private static YeemoSmallMessagePlugin instance;
    @NonNull
    private YeemoSMS yeemoSmallMessageAPI;

    /**
     * When the plugin loads
     *
     * @since 1.0.0
     */
    @Override
    public void onLoad() {
        instance = this;
    }

    /**
     * When this plugin is enabled
     *
     * @since 1.0.0
     */
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.yeemoSmallMessageAPI = new YeemoSMSApiProvider(instance);
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);

    }

    /**
     * When this plugin is disabled
     *
     * @since 1.0.0
     */
    @Override
    public void onDisable() {
        // Plugin stop logic
    }

    /**
     * Get this plugin API instance
     *
     * @return API instance
     * @see YeemoSMS
     * @since 1.0.0
     */
    @NonNull
    public YeemoSMS getAPI() {
        return yeemoSmallMessageAPI;
    }

    /**
     * Get this plugin instance
     *
     * @return Instance
     * @since 1.0.0
     */
    @NonNull
    public static YeemoSmallMessagePlugin getInstance() {
        return instance;
    }
}

