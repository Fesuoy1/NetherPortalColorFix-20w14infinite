package org.mod.portal_updater;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class FixPortalChunkUpdater implements ModInitializer {

    public static final String MOD_ID = "portal_updater-inf";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    
    @Override
    public void onInitialize() {
        LOGGER.info("Nether Portal Color Fix Mod Initialized");
    }
}