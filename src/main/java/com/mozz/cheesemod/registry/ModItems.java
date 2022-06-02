package com.mozz.cheesemod.registry;

import com.mozz.cheesemod.CheeseMod;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.mozz.cheesemod.CheeseMod.REGISTRATE;

public class ModItems {
    private static final Logger LOGGER = LogManager.getLogger(CheeseMod.MODID + "-Items");

    // Gems
    public static final RegistryEntry<Item> MOZZARELLA = REGISTRATE
            .item("mozzarella", Item::new)
            .defaultLang()
            .properties(p -> p)
            .register();

    public static void load() {
        LOGGER.info("Items registered");
    }
}