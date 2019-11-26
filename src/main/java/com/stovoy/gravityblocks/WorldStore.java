package com.stovoy.gravityblocks;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

import java.util.HashMap;

public class WorldStore {
    public final World world;

    public HashMap<ChunkPos, ChunkStore> chunks;

    public WorldStore(World world) {
        this.world = world;
    }
}
