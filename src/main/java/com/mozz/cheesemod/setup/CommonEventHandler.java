package com.mozz.cheesemod.setup;

import com.mozz.cheesemod.CheeseMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@Mod.EventBusSubscriber(modid = CheeseMod.MODID)
@ParametersAreNonnullByDefault
public class CommonEventHandler {
    public static void init(final FMLCommonSetupEvent event) {

    }
}