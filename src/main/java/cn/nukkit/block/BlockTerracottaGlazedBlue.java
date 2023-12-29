package cn.nukkit.block;

import cn.nukkit.utils.DyeColor;

/**
 * @author CreeperFace
 * @since 2.6.2017
 */
public class BlockTerracottaGlazedBlue extends BlockGlazedTerracotta {

    public BlockTerracottaGlazedBlue() {
        this(0);
    }

    public BlockTerracottaGlazedBlue(BlockState blockstate) {
        super(blockstate);
    }

    @Override
    public int getId() {
        return BLUE_GLAZED_TERRACOTTA;
    }

    @Override
    public String getName() {
        return "Blue Glazed Terracotta";
    }

    public DyeColor getDyeColor() {
        return DyeColor.BLUE;
    }
}
