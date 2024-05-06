package net.jonxl04.roofedv.block;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RoofedVMod.MOD_ID);

    public static final RegistryObject<Block> SCRAP_BLOCK = registerBlock("scrap_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(4.5F, 6.0F).sound(SoundType.COPPER).mapColor(MapColor.RAW_IRON)));

    public static final RegistryObject<Block> SCRAP_PLATE_BLOCK = registerBlock("scrap_plate_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(4.5F, 6.0F).sound(SoundType.COPPER).mapColor(MapColor.RAW_IRON)));

    public static final RegistryObject<Block> CUT_SCRAP = registerBlock("cut_scrap",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.SCRAP_BLOCK.get())));

    public static final RegistryObject<Block> SCRAP_ORE = registerBlock("scrap_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));

    public static final RegistryObject<Block> MERCHITE_ORE = registerBlock("merchite_ore",
            () -> new DropExperienceBlock(UniformInt.of(1,2), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_COAL_ORE)));

    public static final RegistryObject<Block> SCRAP_SAND = registerBlock("scrap_sand",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)) {
            });

    public static final RegistryObject<Block> SCRAP_SANDSTONE = registerBlock("scrap_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> SCRAP_SANDSTONE_STAIRS = registerBlock("scrap_sandstone_stairs",
            () -> new StairBlock(ModBlocks.SCRAP_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final RegistryObject<Block> SCRAP_SANDSTONE_SLAB = registerBlock("scrap_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final RegistryObject<Block> SCRAP_SANDSTONE_WALL = registerBlock("scrap_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));


    public static final RegistryObject<Block> SCRAP_CUT_SANDSTONE = registerBlock("scrap_cut_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE)));

    public static final RegistryObject<Block> SCRAP_SMOOTH_SANDSTONE = registerBlock("scrap_smooth_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE)));

    public static final RegistryObject<Block> MERCHITE_BLOCK = registerBlock("merchite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> MERCHITE_CRYSTAL = registerBlock("merchite_crystal",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));

    public static final RegistryObject<Block> MERCHITE_LAMP = registerBlock("merchite_lamp",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.SCRAP_BLOCK.get())));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
