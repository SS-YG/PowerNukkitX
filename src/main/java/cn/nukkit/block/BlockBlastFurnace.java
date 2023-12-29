package cn.nukkit.block;


public class BlockBlastFurnace extends BlockBlastFurnaceBurning {

    public BlockBlastFurnace() {
        this(0);
    }


    public BlockBlastFurnace(BlockState blockstate) {
        super(blockstate);
    }

    @Override
    public String getName() {
        return "Blast Furnace";
    }

    @Override
    public int getId() {
        return BLAST_FURNACE;
    }

    @Override
    public int getLightLevel() {
        return 0;
    }
}
