package com.stovoy.gravityblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GravityBlocks.MODID)
public class GravityBlocks {
    static final String MODID = "gravityblocks";

    private static final Logger LOGGER = LogManager.getLogger(MODID);

    private static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(MODID,
            () -> new ItemStack(ModItems.GRAVITY_BLOCK_ITEM));

    public GravityBlocks() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MODID)
    public static class ModEventSubscriber {
        @SubscribeEvent
        public static void onRegisterBlocks(final RegistryEvent.Register<Block> event) {
            Block gravityBlock = new Block(
                    Block.Properties.create(
                            new Material.Builder(MaterialColor.STONE).build())
                            .hardnessAndResistance(1.0F, 1.0F));
            gravityBlock.setRegistryName(new ResourceLocation(MODID, "gravity_block"));

            event.getRegistry().registerAll(gravityBlock);
        }

        @SubscribeEvent
        public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
            BlockItem gravityBlockItem = new BlockItem(
                    ModItems.GRAVITY_BLOCK, new Item.Properties().group(MOD_ITEM_GROUP));
            gravityBlockItem.setRegistryName(new ResourceLocation(MODID, "gravity_block_item"));

            event.getRegistry().registerAll(gravityBlockItem);
        }
    }

    public static class ModItemGroup extends ItemGroup {
        private final Supplier<ItemStack> iconSupplier;

        ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack createIcon() {
            return iconSupplier.get();
        }
    }

    @ObjectHolder(MODID)
    public static class ModItems {
        public static final BlockItem GRAVITY_BLOCK_ITEM = null;
        public static final Block GRAVITY_BLOCK = null;
    }
}
