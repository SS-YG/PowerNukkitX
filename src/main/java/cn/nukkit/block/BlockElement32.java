package cn.nukkit.block;

import cn.nukkit.block.state.BlockProperties;
import cn.nukkit.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockElement32 extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:element_32");

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockElement32() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockElement32(BlockState blockstate) {
        super(blockstate);
    }
}