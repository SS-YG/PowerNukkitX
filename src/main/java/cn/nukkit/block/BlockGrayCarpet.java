package cn.nukkit.block;

import cn.nukkit.block.state.BlockProperties;
import cn.nukkit.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockGrayCarpet extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:gray_carpet");

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockGrayCarpet() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockGrayCarpet(BlockState blockstate) {
        super(blockstate);
    }
}