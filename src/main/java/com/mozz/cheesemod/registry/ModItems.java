package com.mozz.cheesemod.registry;

import com.mozz.cheesemod.CheeseMod;
import com.mozz.cheesemod.items.SaucepanItem;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.mozz.cheesemod.CheeseMod.REGISTRATE;

public class ModItems {
    private static final Logger LOGGER = LogManager.getLogger(CheeseMod.MODID + "-Items");

    // Gems
    public static final RegistryEntry<Item> FIOR_DI_LATTE_MOZZARELLA = REGISTRATE
            .item("fior_di_latte_mozzarella", Item::new)
            .defaultLang()
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).build()))
            .register();

    // Other Stuff
    public static final RegistryEntry<SaucepanItem> SAUCEPAN = REGISTRATE
            .item("saucepan", SaucepanItem::new)
            .defaultLang()
            .properties(p -> p)
            .recipe((ctx, prov) -> {
                ShapedRecipeBuilder.shaped(ctx.getEntry())
                        .pattern("II ")
                        .pattern(" II")
                        .pattern(" II")
                        .define('I', Items.IRON_INGOT)
                        .unlockedBy("has_iron", RegistrateRecipeProvider.has(Items.IRON_INGOT))
                        .save(prov);
            })
            .register();

    public static void load() {
        LOGGER.info("Items registered");
    }
}