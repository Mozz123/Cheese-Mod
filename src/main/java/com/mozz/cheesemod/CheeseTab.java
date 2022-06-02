package com.mozz.cheesemod;

import com.mozz.cheesemod.registry.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class CheeseTab extends CreativeModeTab {
    public CheeseTab() {
        super(CheeseMod.MODID);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.FIOR_DI_LATTE_MOZZARELLA.get());
    }
}