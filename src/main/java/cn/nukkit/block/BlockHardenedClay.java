package cn.nukkit.block;

import cn.nukkit.block.state.BlockProperties;
import cn.nukkit.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockHardenedClay extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:hardened_clay");

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockHardenedClay() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockHardenedClay(BlockState blockstate) {
        super(blockstate);
    }
}