package com.stovoy.gravityblocks;

import net.minecraft.world.chunk.IChunk;

public class ChunkStore {
    public final IChunk chunk;

    public ChunkStore(IChunk chunk) {
        this.chunk = chunk;
    }
}
