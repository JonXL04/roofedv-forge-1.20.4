package net.jonxl04.roofedv.datagen.loot;

import net.jonxl04.roofedv.block.ModBlocks;
import net.jonxl04.roofedv.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SCRAP_BLOCK.get());
        this.dropSelf(ModBlocks.SCRAP_SAND.get());
        this.dropSelf(ModBlocks.SCRAP_PLATE_BLOCK.get());
        this.dropSelf(ModBlocks.SCRAP_SANDSTONE.get());
        this.dropSelf(ModBlocks.SCRAP_SANDSTONE_WALL.get());
        this.dropSelf(ModBlocks.SCRAP_SANDSTONE_STAIRS.get());
        this.dropSelf(ModBlocks.SCRAP_CUT_SANDSTONE.get());
        this.dropSelf(ModBlocks.SCRAP_SMOOTH_SANDSTONE.get());
        this.dropSelf(ModBlocks.MERCHITE_BLOCK.get());

        this.add(ModBlocks.SCRAP_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SCRAP_SANDSTONE_SLAB.get()));

        this.add(ModBlocks.SCRAP_ORE.get(),
                block -> createCustomOreDrops(ModBlocks.SCRAP_ORE.get(), ModItems.SCRAP_SHARDS.get(),1.0F,2.0F));
        this.add(ModBlocks.MERCHITE_ORE.get(),
                block -> createOreDrop(ModBlocks.MERCHITE_ORE.get(), ModItems.MERCHITE.get()));
    }

    protected LootTable.Builder createCustomOreDrops(Block pBlock, Item item, float min, float max) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}