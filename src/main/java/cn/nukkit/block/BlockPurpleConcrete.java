package cn.nukkit.block;

import cn.nukkit.block.state.BlockProperties;
import cn.nukkit.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockPurpleConcrete extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:purple_concrete");

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockPurpleConcrete() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockPurpleConcrete(BlockState blockstate) {
        super(blockstate);
    }
}