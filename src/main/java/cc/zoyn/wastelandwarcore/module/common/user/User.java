package cc.zoyn.wastelandwarcore.module.common.user;

import cc.zoyn.wastelandwarcore.api.CoreAPI;
import cc.zoyn.wastelandwarcore.module.common.chat.Channel;
import cc.zoyn.wastelandwarcore.module.common.specialeffect.SpecialEffectPlayer;
import cc.zoyn.wastelandwarcore.module.common.talent.Talent;
import cc.zoyn.wastelandwarcore.module.town.Town;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.Validate;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.Map;

/**
 * 表示一个用户
 *
 * @author Zoyn
 * @since 2017-12-16
 */
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements ConfigurationSerializable {
    /**
     * 用户名
     */
    @Getter
    @Setter
    private String name;
    /**
     * 用户所在频道
     */
    @Setter
    private String channel;
    /**
     * 用户所在城镇
     */
    @Setter
    private String town;
    /**
     * 用户天赋
     */
    @Getter
    @Setter
    private Talent talent;
    /**
     * 用户护甲
     */
    @Getter
    @Setter
    private double armor;
    /**
     * 用户抗性
     */
    @Getter
    @Setter
    private double resistance;
    /**
     * 用户速度(未经过效果削弱)
     */
    @Getter
    @Setter
    private float moveSpeed;
    /**
     * 玩家身上效果合集
     */
    @Getter
    @Setter
    private SpecialEffectPlayer effects;

    public Channel getChannel() {
        return CoreAPI.getChannelManager().getChannelByName(channel);
    }

    public Town getTown() {
        return CoreAPI.getTownManager().getTownByName(town);
    }

    public static User deserialize(Map<String, Object> map) {
        Validate.notNull(map);

        User user = new User();
        user.setName((String) map.get("name"));
        user.setChannel((String) map.get("channel"));
        user.setTown((String) map.get("town"));
        user.setTalent((Talent) map.get("talent"));
        user.setArmor((double) map.get("armor"));
        user.setResistance((double) map.get("resistance"));
        user.setMoveSpeed((float) map.get("moveSpeed"));
        user.setEffects((SpecialEffectPlayer) map.get("effects"));
        return user;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("name", name);
        map.put("channel", channel);
        map.put("town", town);
        map.put("talent", talent);
        map.put("armor",armor);
        map.put("resistance",resistance);
        map.put("moveSpeed",moveSpeed);
        map.put("effects",effects);
        return map;
    }
}
