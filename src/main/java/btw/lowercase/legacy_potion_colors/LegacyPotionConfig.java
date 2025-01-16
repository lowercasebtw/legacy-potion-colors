package btw.lowercase.legacy_potion_colors;

import eu.midnightdust.lib.config.MidnightConfig;

public class LegacyPotionConfig extends MidnightConfig {
    @Entry(category = "legacy_potion")
    public static boolean OLD_POTION_COLORS = true;

    @Entry(category = "legacy_potion")
    public static boolean POTION_GLINT = true;

    @Entry(category = "legacy_potion")
    public static boolean EFFECTS_HUD = true;
}