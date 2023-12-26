package cn.nukkit.block;

import cn.nukkit.block.state.BlockProperties;
import cn.nukkit.block.state.BlockState;
import cn.nukkit.block.state.property.CommonBlockProperties;
import org.jetbrains.annotations.NotNull;

public class BlockAcaciaFenceGate extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:acacia_fence_gate", CommonBlockProperties.DIRECTION, CommonBlockProperties.IN_WALL_BIT, CommonBlockProperties.OPEN_BIT);

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockAcaciaFenceGate() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockAcaciaFenceGate(BlockState blockstate) {
        super(blockstate);
    }
}