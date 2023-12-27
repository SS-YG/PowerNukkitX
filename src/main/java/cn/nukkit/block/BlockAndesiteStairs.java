package cn.nukkit.block;

import cn.nukkit.block.property.CommonBlockProperties;
import org.jetbrains.annotations.NotNull;

public class BlockAndesiteStairs extends Block {
    public static final BlockProperties PROPERTIES = new BlockProperties("minecraft:andesite_stairs", CommonBlockProperties.UPSIDE_DOWN_BIT, CommonBlockProperties.WEIRDO_DIRECTION);

    @Override
    public @NotNull BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockAndesiteStairs() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockAndesiteStairs(BlockState blockstate) {
        super(blockstate);
    }
}