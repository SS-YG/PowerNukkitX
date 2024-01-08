package cn.nukkit.event.level;

import cn.nukkit.event.HandlerList;
import cn.nukkit.level.Level;
import lombok.Getter;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class LevelSaveEvent extends LevelEvent {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public LevelSaveEvent(Level level) {
        super(level);
    }

}
