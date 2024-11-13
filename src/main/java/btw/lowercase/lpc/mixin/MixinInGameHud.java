package btw.lowercase.lpc.mixin;

import btw.lowercase.lpc.LegacyPotionConfig;
import net.minecraft.client.gui.Gui;
import net.minecraft.world.effect.MobEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Collection;

@Mixin(value = Gui.class, priority = Integer.MAX_VALUE)
public class MixinInGameHud {
    @Redirect(method = "renderEffects", at = @At(value = "INVOKE", target = "Ljava/util/Collection;isEmpty()Z"))
    private boolean renderEffects$toggleEffectsHud(Collection<MobEffectInstance> instance) {
        return !LegacyPotionConfig.EFFECTS_HUD || instance.isEmpty();
    }
}
