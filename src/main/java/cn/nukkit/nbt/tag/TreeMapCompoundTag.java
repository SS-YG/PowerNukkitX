package cn.nukkit.nbt.tag;

import cn.nukkit.nbt.stream.NBTInputStream;
import cn.nukkit.nbt.stream.NBTOutputStream;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapCompoundTag extends CompoundTag {
    public TreeMapCompoundTag() {
        this("");
    }

    public TreeMapCompoundTag(String name) {
        super(name, new TreeMap<>());
    }

    @Override
    public Map<String, Tag> getTags() {
        return new TreeMap<>(this.tags);
    }

    @Override
    public Map<String, Object> parseValue() {
        Map<String, Object> value = new TreeMap<>();

        for (Map.Entry<String, Tag> entry : this.tags.entrySet()) {
            value.put(entry.getKey(), entry.getValue().parseValue());
        }

        return value;
    }

    @Override
    public TreeMapCompoundTag copy() {
        var nbt = new TreeMapCompoundTag();
        this.getTags().forEach((key, value) -> nbt.put(key, value.copy()));
        return nbt;
    }
}
