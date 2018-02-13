package cc.zoyn.wastelandwarcore.model;

import cc.zoyn.wastelandwarcore.api.CoreAPI;
import cc.zoyn.wastelandwarcore.module.common.user.User;
import lombok.*;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.*;

/**
 * 代表一个联盟
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Alliance implements ConfigurationSerializable {
    @Getter
    private final UUID uniqueId;
    @Getter
    private final boolean rebel;
    @Getter
    private List<User> allies = new ArrayList<>();
    @Getter
    @Setter
    private List<Town> towns = new ArrayList<>();
    @Getter
    @Setter
    private String leader;

    public Alliance(UUID uniqueId) {
        this.rebel = false;
        this.uniqueId = uniqueId;
    }

    public Alliance(String leader) {
        this.rebel = false;
        this.uniqueId = UUID.randomUUID();
        this.leader = leader;
    }

    public static Alliance deserialize(Map<String, Object> map) {
        return new Alliance(UUID.fromString((String) map.get("uniqueId")),
                (Boolean) map.get("isRebel"),
                (List<User>) map.get("allies"),
                (List<Town>) map.get("towns"),
                (String) map.get("leader"));
    }

    /**
     * 从城镇中踢出一个盟军
     *
     * @param ally 欲踢出的盟军
     */
    public void kick(User ally) {
        this.allies.remove(ally);
    }

    /**
     * 返回能容纳的最大成员数.
     * <p>标准联盟为 城镇数 * 15 +1 </p>
     * <p>叛军为 15</p>
     *
     * @return 能容纳的最大成员数
     */
    public int getMaxAlliesCount() {
        return isRebel() ? 15 : towns.size() * 15 + 1;
    }

    /**
     * 将某个盟军添加到联盟中，如果添加失败返回false
     *
     * @param ally 盟军
     * @return 成功则返回true
     */
    public boolean join(User ally) {
        if (allies.size() < getMaxAlliesCount()) {
            allies.add(ally);
            return true;
        }
        return false;
    }

    public User getLeader() {
        return CoreAPI.getUserManager().getUserByName(leader);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> serialized = new HashMap<>();
        serialized.put("uniqueId", getUniqueId().toString());
        serialized.put("allies", getAllies().stream().map(User::getName).toArray());
        serialized.put("towns", getTowns().stream().map(town -> town.getUniqueId().toString()).toArray());
        serialized.put("leader", leader);
        serialized.put("isRebel", isRebel());
        return serialized;
    }

    public String getName() {
        return leader + "势力";
    }
}
