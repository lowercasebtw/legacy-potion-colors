package btw.lowercase.legacy_potion_colors.mixin;

import btw.lowercase.legacy_potion_colors.LegacyPotionConfig;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Item.class, priority = Integer.MAX_VALUE)
public class MixinItem {
    @Inject(method = "isFoil", at = @At("RETURN"), cancellable = true)
    private void legacyPotionColors$isFoil$potionGlint(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (LegacyPotionConfig.POTION_GLINT && stack.getItem() instanceof PotionItem) {
            boolean hasGlintOverrideComponent = stack.getComponents().has(DataComponents.ENCHANTMENT_GLINT_OVERRIDE);
            if (!hasGlintOverrideComponent) {
                PotionContents potionComponent = stack.getComponents().get(DataComponents.POTION_CONTENTS);
                if (potionComponent != null) {
                    cir.setReturnValue(potionComponent.hasEffects());
                }
            }
        }
    }
}