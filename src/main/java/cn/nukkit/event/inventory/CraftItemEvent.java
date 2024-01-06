/*
package cn.nukkit.event.inventory;

import cn.nukkit.Player;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.Event;
import cn.nukkit.event.HandlerList;
import cn.nukkit.recipe.Recipe;
import cn.nukkit.inventory.transaction.CraftingTransaction;
import cn.nukkit.item.Item;
import lombok.Getter;

*/
/**
 * @author MagicDroidX (Nukkit Project)
 *//*

public class CraftItemEvent extends Event implements Cancellable {

    @Getter
    private static final HandlerList handlers = new HandlerList();

    private final Recipe recipe;
    private final Player player;
    private final Item[] input;
    private CraftingTransaction transaction;

    public CraftItemEvent(CraftingTransaction transaction) {
        this.transaction = transaction;

        this.player = transaction.getSource();
        this.input = transaction.getInputList().toArray(Item.EMPTY_ARRAY);
        this.recipe = transaction.getTransactionRecipe();
    }

    public CraftItemEvent(Player player, Item[] input, Recipe recipe) {
        this.player = player;
        this.input = input;
        this.recipe = recipe;
    }

    public CraftingTransaction getTransaction() {
        return transaction;
    }

    public Item[] getInput() {
        return input;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Player getPlayer() {
        return this.player;
    }
}
*/
