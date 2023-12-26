package cn.nukkit.block;

import cn.nukkit.block.state.BlockProperties;
import cn.nukkit.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockMagentaConcrete extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:magenta_concrete");

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockMagentaConcrete() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockMagentaConcrete(BlockState blockstate) {
        super(blockstate);
    }
}