package dev.ithundxr.mods.oldmclogo.fabric;

import dev.ithundxr.mods.oldmclogo.OldMCLogo;
import net.fabricmc.api.ModInitializer;

public class OldMCLogoFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        OldMCLogo.init();
    }
}