package com.mozz.cheesemod.setup;

import com.mozz.cheesemod.BotwMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@Mod.EventBusSubscriber(modid = BotwMod.MODID)
@ParametersAreNonnullByDefault
public class CommonEventHandler {
    public static void init(final FMLCommonSetupEvent event) {

    }
}