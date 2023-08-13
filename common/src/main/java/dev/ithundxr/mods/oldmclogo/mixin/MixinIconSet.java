package dev.ithundxr.mods.oldmclogo.mixin;

import com.mojang.blaze3d.platform.IconSet;
import dev.ithundxr.mods.oldmclogo.OldMCLogo;
import net.minecraft.client.Minecraft;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.resources.IoSupplier;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import java.io.InputStream;

@Mixin(IconSet.class)
public class MixinIconSet {
    @Inject(method = "getFile", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void returnBetterFile(PackResources packResources, String string, CallbackInfoReturnable<IoSupplier<InputStream>> cir, String[] strings, IoSupplier<InputStream> ioSupplier) {
        // Resource Manager
        ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
        // Return old icons
        cir.setReturnValue(() -> resourceManager.getResourceOrThrow(OldMCLogo.asResource(string)).open());
    }
}