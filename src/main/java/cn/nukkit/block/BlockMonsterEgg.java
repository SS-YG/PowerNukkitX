package cn.nukkit.block;

import cn.nukkit.blockproperty.ArrayBlockProperty;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.value.MonsterEggStoneType;
import cn.nukkit.item.Item;
import org.jetbrains.annotations.NotNull;

public class BlockMonsterEgg extends BlockSolidMeta {


    public static final ArrayBlockProperty<MonsterEggStoneType> MONSTER_EGG_STONE_TYPE = new ArrayBlockProperty<>(
            "monster_egg_stone_type", true, MonsterEggStoneType.class);


    public static final BlockProperties PROPERTIES = new BlockProperties(MONSTER_EGG_STONE_TYPE);

    public static final int STONE = 0;
    public static final int COBBLESTONE = 1;
    public static final int STONE_BRICK = 2;
    public static final int MOSSY_BRICK = 3;
    public static final int CRACKED_BRICK = 4;
    public static final int CHISELED_BRICK = 5;

    private static final String[] NAMES = new String[]{
            "Stone",
            "Cobblestone",
            "Stone Brick",
            "Mossy Stone Brick",
            "Cracked Stone Brick",
            "Chiseled Stone Brick"
    };

    public BlockMonsterEgg() {
        this(0);
    }

    public BlockMonsterEgg(BlockState blockstate) {
        super(blockstate);
    }

    @Override
    public int getId() {
        return MONSTER_EGG;
    }


    @NotNull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }


    @NotNull
    public MonsterEggStoneType getMonsterEggStoneType() {
        return getPropertyValue(MONSTER_EGG_STONE_TYPE);
    }


    public void setMonsterEggStoneType(@NotNull MonsterEggStoneType value) {
        setPropertyValue(MONSTER_EGG_STONE_TYPE, value);
    }

    @Override
    public double getHardness() {
        return 0;
    }

    @Override
    public double getResistance() {
        return 0.75;
    }

    @Override
    public String getName() {
        return NAMES[this.getDamage() > 5 ? 0 : this.getDamage()] + " Monster Egg";
    }

    @Override
    public Item[] getDrops(Item item) {
        return Item.EMPTY_ARRAY;
    }
}
