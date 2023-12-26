package cn.nukkit.block;

import cn.nukkit.block.state.BlockProperties;
import cn.nukkit.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockBrownWool extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:brown_wool");

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockBrownWool() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockBrownWool(BlockState blockstate) {
        super(blockstate);
    }
}