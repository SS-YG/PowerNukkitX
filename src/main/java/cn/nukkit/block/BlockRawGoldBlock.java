package cn.nukkit.block;

import cn.nukkit.block.state.BlockProperties;
import cn.nukkit.block.state.BlockState;
import cn.nukkit.block.state.property.CommonBlockProperties;
import cn.nukkit.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockRawGoldBlock extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:raw_gold_block");

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockRawGoldBlock() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockRawGoldBlock(BlockState blockstate) {
        super(blockstate);
    }
}