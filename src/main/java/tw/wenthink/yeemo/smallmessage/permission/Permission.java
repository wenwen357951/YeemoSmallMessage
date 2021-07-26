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
