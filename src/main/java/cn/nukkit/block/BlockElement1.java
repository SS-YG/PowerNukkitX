package cn.nukkit.block;

import cn.nukkit.block.state.BlockProperties;
import cn.nukkit.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockElement1 extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:element_1");

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockElement1() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockElement1(BlockState blockstate) {
        super(blockstate);
    }
}