package cn.nukkit.block;

import cn.nukkit.block.state.BlockProperties;
import cn.nukkit.block.state.BlockState;
import cn.nukkit.block.state.property.CommonBlockProperties;
import cn.nukkit.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockFireCoral extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:fire_coral");

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockFireCoral() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockFireCoral(BlockState blockstate) {
        super(blockstate);
    }
}