package com.mozz.cheesemod.items;

import com.mozz.cheesemod.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class SaucepanItem extends Item {
    public SaucepanItem(Properties builder) {
        super(builder);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);

        if (state.getBlock() == Blocks.CAMPFIRE && stack.is(ModItems.SAUCEPAN.get())) {
            if (player != null && !world.isClientSide) {
                world.setBlock(pos, Blocks.MOSSY_COBBLESTONE.defaultBlockState(), 11);
                stack.shrink(1);
            }
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else {
            return InteractionResult.FAIL;
        }
    }
}