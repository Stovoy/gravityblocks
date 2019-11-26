package com.stovoy.gravityblocks;

import net.minecraft.util.math.ChunkPos;

import java.util.HashMap;

public class DataStore {
    private DataStore() {}

    // public static HashMap<DimensionType, WorldStore> worlds = new HashMap<>();
    public static HashMap<ChunkPos, ChunkStore> chunks = new HashMap<>();
}
