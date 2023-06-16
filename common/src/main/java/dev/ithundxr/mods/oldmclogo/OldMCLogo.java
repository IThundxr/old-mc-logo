package dev.ithundxr.mods.oldmclogo;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OldMCLogo {
    public static final String MOD_ID = "oldmclogo";
    public static final String NAME = "Old MC Logo";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);


    public static void init() {
        LOGGER.info("Mod Successfully Loaded");
    }
}
