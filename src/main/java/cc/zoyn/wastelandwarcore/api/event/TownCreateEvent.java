package cc.zoyn.wastelandwarcore.api.event;

import cc.zoyn.wastelandwarcore.module.town.Town;
import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author Zoyn
 * @since 2017-12-09
 */
public class TownCreateEvent extends Event implements Cancellable {

    @Getter
    private final Town town;

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;

    public TownCreateEvent(Town town) {
        this.town = town;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}