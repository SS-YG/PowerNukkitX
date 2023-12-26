package cn.nukkit.block;

import cn.nukkit.block.state.BlockProperties;
import cn.nukkit.block.state.BlockState;
import cn.nukkit.block.state.property.CommonBlockProperties;
import cn.nukkit.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockFrame extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:frame", CommonBlockProperties.FACING_DIRECTION, CommonBlockProperties.ITEM_FRAME_MAP_BIT, CommonBlockProperties.ITEM_FRAME_PHOTO_BIT);

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockFrame() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockFrame(BlockState blockstate) {
        super(blockstate);
    }
}