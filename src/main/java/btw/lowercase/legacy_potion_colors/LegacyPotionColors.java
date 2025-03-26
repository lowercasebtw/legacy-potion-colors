package btw.lowercase.legacy_potion_colors;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.world.item.Item;

public class LegacyPotionColors implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MidnightConfig.init("legacy_potion_colors", LegacyPotionConfig.class);
    }
}