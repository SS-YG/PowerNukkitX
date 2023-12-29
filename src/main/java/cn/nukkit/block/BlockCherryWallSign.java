package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemCherrySign;


public class BlockCherryWallSign extends BlockWallSign {
    public BlockCherryWallSign() {
        this(0);
    }

    public BlockCherryWallSign(BlockState blockstate) {
        super(blockstate);
    }

    @Override
    public int getId() {
        return CHERRY_WALL_SIGN;
    }

    @Override
    protected int getPostId() {
        return CHERRY_STANDING_SIGN;
    }

    @Override
    public String getName() {
        return "Cherry Wall Sign";
    }

    @Override
    public Item toItem() {
        return new ItemCherrySign();
    }

}
