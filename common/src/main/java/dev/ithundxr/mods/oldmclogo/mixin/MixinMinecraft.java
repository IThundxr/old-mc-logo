package dev.ithundxr.mods.oldmclogo.mixin;

import com.mojang.blaze3d.platform.IconSet;
import com.mojang.blaze3d.platform.Window;
import dev.ithundxr.mods.oldmclogo.OldMCLogo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.VanillaPackResources;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Shadow @Final private Window window;
    @Shadow @Final private VanillaPackResources vanillaPackResources;

    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;setIcon(Lnet/minecraft/server/packs/PackResources;Lcom/mojang/blaze3d/platform/IconSet;)V"))
    private void init(Window instance, PackResources packResources, IconSet iconSet) {
        OldMCLogo.LOGGER.info("Trying to change Icon");
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void setIcon(GameConfig gameConfig, CallbackInfo ci) {
        try {
            window.setIcon(vanillaPackResources, IconSet.RELEASE);
        } catch (Exception e) {
            OldMCLogo.LOGGER.error("Error while trying to set icon...", e);
        }
    }
}
