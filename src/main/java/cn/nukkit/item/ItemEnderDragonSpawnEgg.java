package cn.nukkit.item;

public class ItemEnderDragonSpawnEgg extends ItemSpawnEgg {
    public ItemEnderDragonSpawnEgg() {
        super(ENDER_DRAGON_SPAWN_EGG);
    }

    @Override
    public int getEntityNetworkId() {
        return;
    }

    @Override
    public void setDamage(Integer meta) {
        throw new UnsupportedOperationException();
    }
}