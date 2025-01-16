package btw.lowercase.legacy_potion_colors.mixin;

import btw.lowercase.legacy_potion_colors.LegacyPotionConfig;
import net.minecraft.world.effect.MobEffect;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;

@Mixin(value = MobEffect.class, priority = Integer.MAX_VALUE)
public class MixinMobEffect {
    @Unique
    private static final Map<String, Integer> OLD_POTION_COLORS = new HashMap<>();

    static {
        // Old Potion Colors (https://github.com/sp614x/optifine/blob/master/OptiFineDoc/doc/color.properties) + Other sources
        OLD_POTION_COLORS.put("effect.minecraft.absorption", 0x2552A5);
        OLD_POTION_COLORS.put("effect.minecraft.bad_omen", 0xB6138);
        OLD_POTION_COLORS.put("effect.minecraft.blindness", 0x1F1F23);
        OLD_POTION_COLORS.put("effect.minecraft.conduit_power", 0x1DC2D1);
        OLD_POTION_COLORS.put("effect.minecraft.darkness", 16750848);
        OLD_POTION_COLORS.put("effect.minecraft.dolphins_grace", 0x88A3BE);
        OLD_POTION_COLORS.put("effect.minecraft.fire_resistance", 0xE49A3A);
        OLD_POTION_COLORS.put("effect.minecraft.glowing", 0x94A061);
        OLD_POTION_COLORS.put("effect.minecraft.haste", 0xD9C043);
        OLD_POTION_COLORS.put("effect.minecraft.health_boost", 0xF87D23);
        OLD_POTION_COLORS.put("effect.minecraft.hero_of_the_village", 0x44FF44);
        OLD_POTION_COLORS.put("effect.minecraft.hunger", 0x587653);
        OLD_POTION_COLORS.put("effect.minecraft.instant_damage", 0x430A09);
        OLD_POTION_COLORS.put("effect.minecraft.instant_health", 0xF82423);
        OLD_POTION_COLORS.put("effect.minecraft.invisibility", 0x7F8392);
        OLD_POTION_COLORS.put("effect.minecraft.jump_boost", 0x22FF4C);
        OLD_POTION_COLORS.put("effect.minecraft.levitation", 0xCEFFFF);
        OLD_POTION_COLORS.put("effect.minecraft.luck", 0x339900);
        OLD_POTION_COLORS.put("effect.minecraft.mining_fatigue", 0x4A4217);
        OLD_POTION_COLORS.put("effect.minecraft.nausea", 0x551D4A);
        OLD_POTION_COLORS.put("effect.minecraft.night_vision", 0x1F1FA1);
        OLD_POTION_COLORS.put("effect.minecraft.poison", 0x4E9331);
        OLD_POTION_COLORS.put("effect.minecraft.regeneration", 0xCD5CAB);
        OLD_POTION_COLORS.put("effect.minecraft.resistance", 0x99453A);
        OLD_POTION_COLORS.put("effect.minecraft.saturation", 0xF82423);
        OLD_POTION_COLORS.put("effect.minecraft.slow_falling", 0xFFEFD1);
        OLD_POTION_COLORS.put("effect.minecraft.slowness", 0x5A6C81);
        OLD_POTION_COLORS.put("effect.minecraft.speed", 0x7CAFC6);
        OLD_POTION_COLORS.put("effect.minecraft.strength", 0x932423);
        OLD_POTION_COLORS.put("effect.minecraft.unluck", 0xC0A44D);
        OLD_POTION_COLORS.put("effect.minecraft.water_breathing", 0x2E5299);
        OLD_POTION_COLORS.put("effect.minecraft.weakness", 0x484D48);
        OLD_POTION_COLORS.put("effect.minecraft.wither", 0x352A27);
    }

    // 0x292721 // ???

    @Shadow
    @Nullable
    private String descriptionId;

    @Inject(method = "getColor", at = @At("RETURN"), cancellable = true)
    private void getColor$oldPotionColors(CallbackInfoReturnable<Integer> cir) {
        if (LegacyPotionConfig.OLD_POTION_COLORS && descriptionId != null && OLD_POTION_COLORS.containsKey(descriptionId)) {
            cir.setReturnValue(OLD_POTION_COLORS.get(descriptionId));
        }
    }
}
