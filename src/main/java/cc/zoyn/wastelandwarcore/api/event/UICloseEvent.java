package cc.zoyn.wastelandwarcore.api.event;

import cc.zoyn.wastelandwarcore.module.common.ui.UI;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * 当UI被关闭时触发此事件
 *
 * @author hammer354
 * @since 2017-12-13
 */
public class UICloseEvent extends Event {

    @Getter
    private final UI ui;

    private static final HandlerList handlers = new HandlerList();

    public UICloseEvent(UI ui) {
        this.ui = ui;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
