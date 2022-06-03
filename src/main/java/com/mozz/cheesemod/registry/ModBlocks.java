package com.mozz.cheesemod.registry;

import com.mozz.cheesemod.CheeseMod;
import com.mozz.cheesemod.blocks.PotBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.ToIntFunction;

import static com.mozz.cheesemod.CheeseMod.REGISTRATE;

public class ModBlocks {
    private static final Logger LOGGER = LogManager.getLogger(CheeseMod.MODID + "-Blocks");

    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }

    // TODO
    public static final BlockEntry<PotBlock> POT_BLOCK = REGISTRATE
            .block("pot_block", PotBlock::new)
            .initialProperties(Material.WOOD, MaterialColor.PODZOL)
            .properties(p -> p.strength(3.0f).lightLevel(litBlockEmission(15)))
            .defaultLang()
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), prov.models().getExistingFile(prov.modLoc(ctx.getName()))))
            .loot((tables, block) -> tables.add(block, LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(ModItems.SAUCEPAN.get()))
                            .add(LootItem.lootTableItem(Items.CAMPFIRE))
                            .when(ExplosionCondition.survivesExplosion()))))
            .register();

    public static void load() {
        LOGGER.info("Blocks registered");
    }
}