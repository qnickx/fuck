package cc.zoyn.wastelandwarcore.api.event;

import cc.zoyn.wastelandwarcore.module.common.ui.UI;
import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * 当UI被点击时触发此事件
 *
 * @author hammer354
 * @since 2017-12-13
 */
public class UIClickEvent extends Event implements Cancellable {

    @Getter
    private final UI ui;

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;

    public UIClickEvent(UI ui) {
        this.ui = ui;
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
