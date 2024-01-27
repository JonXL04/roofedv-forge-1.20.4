package net.jonxl04.roofedv.datagen;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.block.ModBlocks;
import net.jonxl04.roofedv.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike>
            SCRAP_BLASTABLES = List.of(
            ModItems.SCRAP_SHARDS.get(), ModBlocks.SCRAP_ORE.get(), ModBlocks.SCRAP_SANDSTONE.get(),
            ModBlocks.SCRAP_SMOOTH_SANDSTONE.get(), ModBlocks.SCRAP_CUT_SANDSTONE.get()),
            SCRAP_SMELTABLES = List.of(
            ModItems.SCRAP_SHARDS.get(), ModBlocks.SCRAP_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {


        //Scrap metal
        oreSmelting(pRecipeOutput, SCRAP_SMELTABLES, RecipeCategory.MISC, (ItemLike) ModItems.SCRAP_INGOT.get(), 0.7F, 200, "scrap");
        oreBlasting(pRecipeOutput, SCRAP_BLASTABLES, RecipeCategory.MISC, (ItemLike) ModItems.SCRAP_INGOT.get(), 0.7F, 100, "scrap");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SCRAP_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S',ModItems.SCRAP_INGOT.get())
                .unlockedBy(getHasName(ModItems.SCRAP_INGOT.get()), has(ModItems.SCRAP_INGOT.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SCRAP_INGOT.get(), 9)
                .requires(ModBlocks.SCRAP_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SCRAP_BLOCK.get()), has(ModBlocks.SCRAP_BLOCK.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SCRAP_PLATE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S',ModItems.SCRAP_SHARDS.get())
                .unlockedBy(getHasName(ModItems.SCRAP_SHARDS.get()), has(ModItems.SCRAP_SHARDS.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SCRAP_SHARDS.get(), 9)
                .requires(ModBlocks.SCRAP_PLATE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SCRAP_PLATE_BLOCK.get()), has(ModBlocks.SCRAP_PLATE_BLOCK.get()))
                .save(pRecipeOutput);

        //Scrap Tools
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SCRAP_SWORD.get())
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" I ")
                .define('S',ModItems.SCRAP_INGOT.get())
                .define('I',Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(ModItems.SCRAP_INGOT.get()), has(ModItems.SCRAP_INGOT.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SCRAP_PICKAXE.get())
                .pattern("SSS")
                .pattern(" I ")
                .pattern(" I ")
                .define('S',ModItems.SCRAP_INGOT.get())
                .define('I',Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(ModItems.SCRAP_INGOT.get()), has(ModItems.SCRAP_INGOT.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SCRAP_SHOVEL.get())
                .pattern(" S ")
                .pattern(" I ")
                .pattern(" I ")
                .define('S',ModItems.SCRAP_INGOT.get())
                .define('I',Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(ModItems.SCRAP_INGOT.get()), has(ModItems.SCRAP_INGOT.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SCRAP_AXE.get())
                .pattern("SS ")
                .pattern("SI ")
                .pattern(" I ")
                .define('S',ModItems.SCRAP_INGOT.get())
                .define('I',Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(ModItems.SCRAP_INGOT.get()), has(ModItems.SCRAP_INGOT.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SCRAP_HOE.get())
                .pattern("SS ")
                .pattern(" I ")
                .pattern(" I ")
                .define('S',ModItems.SCRAP_INGOT.get())
                .define('I',Tags.Items.RODS_WOODEN)
                .unlockedBy(getHasName(ModItems.SCRAP_INGOT.get()), has(ModItems.SCRAP_INGOT.get()))
                .save(pRecipeOutput);

        //Scrap sand
        oreSmelting(pRecipeOutput, Collections.singletonList(ModBlocks.SCRAP_SANDSTONE.get()), RecipeCategory.MISC, (ItemLike) ModBlocks.SCRAP_SMOOTH_SANDSTONE.get(), 0.7F, 200, "scrap_sandstone");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SCRAP_SANDSTONE.get())
                .pattern("SS")
                .pattern("SS")
                .define('S',ModBlocks.SCRAP_SAND.get())
                .unlockedBy(getHasName(ModBlocks.SCRAP_SAND.get()), has(ModBlocks.SCRAP_SAND.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SCRAP_CUT_SANDSTONE.get())
                .pattern("SS")
                .pattern("SS")
                .define('S',ModBlocks.SCRAP_SANDSTONE.get())
                .unlockedBy(getHasName(ModBlocks.SCRAP_SANDSTONE.get()), has(ModBlocks.SCRAP_SANDSTONE.get()))
                .save(pRecipeOutput);

        //Merchite
        oreSmelting(pRecipeOutput, Collections.singletonList(ModBlocks.MERCHITE_ORE.get()), RecipeCategory.MISC, (ItemLike) ModItems.MERCHITE.get(), 0.7F, 200, "merchite");
        oreBlasting(pRecipeOutput, Collections.singletonList(ModBlocks.MERCHITE_ORE.get()), RecipeCategory.MISC, (ItemLike) ModItems.MERCHITE.get(), 0.7F, 200, "merchite");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MERCHITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S',ModItems.MERCHITE.get())
                .unlockedBy(getHasName(ModItems.MERCHITE.get()), has(ModItems.MERCHITE.get()))
                .save(pRecipeOutput);
        /*ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MERCHITE.get(), 9)
                .requires(ModBlocks.MERCHITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MERCHITE_BLOCK.get()), has(ModBlocks.MERCHITE_BLOCK.get()))
                .save(pRecipeOutput);*/

        /*ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MERCHITE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S',ModItems.MERCHITE_SHARD.get())
                .unlockedBy(getHasName(ModItems.MERCHITE_SHARD.get()), has(ModItems.MERCHITE_SHARD.get()))
                .save(pRecipeOutput);*/
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MERCHITE_SHARD.get(), 9)
                .requires(ModItems.MERCHITE.get())
                .unlockedBy(getHasName(ModItems.MERCHITE.get()), has(ModItems.MERCHITE.get()))
                .save(pRecipeOutput);
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)  .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, RoofedVMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
