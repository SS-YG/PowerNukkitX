package cn.nukkit.item;

import cn.nukkit.item.Item;

public class ItemTraderLlamaSpawnEgg extends ItemSpawnEgg {
    public ItemTraderLlamaSpawnEgg() {
        super(TRADER_LLAMA_SPAWN_EGG);
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