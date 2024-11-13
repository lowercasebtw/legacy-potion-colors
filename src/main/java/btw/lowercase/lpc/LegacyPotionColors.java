package btw.lowercase.lpc;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ClientModInitializer;

public class LegacyPotionColors implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MidnightConfig.init("legacy-potion-colors", LegacyPotionConfig.class);
    }
}