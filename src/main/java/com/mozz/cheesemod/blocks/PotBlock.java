package com.mozz.cheesemod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class PotBlock extends Block {
    private static VoxelShape SHAPE = Stream.of(
            Block.box(7, 10, 1, 9, 11, 3), Block.box(1, 0, 0, 5, 4, 16),
            Block.box(0, 3, 11, 16, 7, 15), Block.box(11, 0, 0, 15, 4, 16),
            Block.box(0, 3, 1, 16, 7, 5), Block.box(5, 0, 0, 11, 1, 16),
            Block.box(4, 7, 4, 12, 8, 12), Block.box(11, 8, 4, 12, 13, 12),
            Block.box(4, 8, 4, 5, 13, 12), Block.box(5, 8, 4, 11, 13, 5),
            Block.box(5, 8, 11, 11, 13, 12), Block.box(7, 9, 3, 9, 10, 4),
            Block.box(7, 11, -3, 9, 12, 1)).reduce((v1, v2) -> {
                return Shapes.join(v1, v2, BooleanOp.OR);}).get();
    public PotBlock(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }


}