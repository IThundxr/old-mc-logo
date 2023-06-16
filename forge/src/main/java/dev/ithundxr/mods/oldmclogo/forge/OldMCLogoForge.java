package dev.ithundxr.mods.oldmclogo.forge;

import dev.ithundxr.mods.oldmclogo.OldMCLogo;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OldMCLogo.MOD_ID)
public class OldMCLogoForge {
    public OldMCLogoForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        OldMCLogo.init();
    }
}
