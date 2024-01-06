package cn.nukkit.item;

import cn.nukkit.utils.DyeColor;

public class ItemLapisLazuli extends ItemDye {
    public ItemLapisLazuli() {
        super(LAPIS_LAZULI);
    }

    @Override
    public DyeColor getDyeColor() {
        return DyeColor.BLUE;
    }

    @Override
    public void setDamage(Integer meta) {
        throw new UnsupportedOperationException();
    }
}