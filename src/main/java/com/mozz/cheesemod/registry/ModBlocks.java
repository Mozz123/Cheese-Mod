package com.mozz.cheesemod.registry;

import com.mozz.cheesemod.CheeseMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModBlocks {
    private static final Logger LOGGER = LogManager.getLogger(CheeseMod.MODID + "-Blocks");

    public static void load() {
        LOGGER.info("Blocks registered");
    }
}