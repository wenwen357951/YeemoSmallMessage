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

/**
 * Select the parse version you want!
 *
 * @author ShengWen-Chen wenwen357951@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ParseVersion {
    /**
     * only encapsulation
     */
    NONE(0),
    /**
     * use tag parse
     *
     * <p>
     * {@code "<blue>I am blue text <red>now is red </red>then turn back blue</blue>"}
     * </p>
     */
    ONLY_TAG(1),
    /**
     * use legacy parse
     *
     * <p>
     * {@code "&9I am blue text &cnow is red &9then turn back blue"}
     * </p>
     */
    ONLY_LEGACY(2),
    /**
     * use legacy and tag parse
     *
     * <p>
     * {@code "&9I am blue text <red>now is red </red>then turn back blue"}
     * </p>
     */
    BOTH(3);

    private final int parseVersion;

    ParseVersion(int parseVersion) {
        this.parseVersion = parseVersion;
    }

    boolean isParseVersion(ParseVersion parseVersion) {
        return this.parseVersion == parseVersion.parseVersion;
    }
}
