package mc.craig.software.angels.data.forge;


import mc.craig.software.angels.WeepingAngels;
import mc.craig.software.angels.common.blocks.WABlocks;
import mc.craig.software.angels.common.items.WAItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {
    public RecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(WAItems.TIMEY_WIMEY_DETECTOR.get()).pattern("#R#").pattern("COV").pattern("BBB").define('#', Blocks.REPEATER.asItem()).define('R', Blocks.REDSTONE_TORCH.asItem()).define('C', Items.CLOCK).define('O', ItemTags.PLANKS).define('V', Items.REDSTONE).define('B', Blocks.BRICKS).unlockedBy("has_clock", has(Items.CLOCK)).save(consumer);
        ShapedRecipeBuilder.shaped(WABlocks.STATUE.get()).pattern("#").pattern("S").define('#', Blocks.STONE.asItem()).define('S', Blocks.SMOOTH_STONE.asItem()).unlockedBy("has_stone", has(Tags.Items.STONE)).save(consumer);
        ShapedRecipeBuilder.shaped(WABlocks.COFFIN.get()).pattern("WWW").pattern("WBW").pattern("WWW").define('W', ItemTags.LOGS).define('B', Items.BONE.asItem()).unlockedBy("has_bone", has(Tags.Items.BONES)).save(consumer);
        ShapedRecipeBuilder.shaped(WAItems.CHRONODYNE_GENERATOR.get(), 2).pattern("IPI").pattern("EKE").pattern("IRI").define('I', Items.IRON_INGOT).define('E', Items.CLOCK.asItem()).define('R', Items.REDSTONE).define('P', Blocks.STONE_BUTTON).define('K', WAItems.KONTRON_INGOT.get()).unlockedBy("has_kontron", has(WABlocks.KONTRON_ORE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(WAItems.CHISEL.get()).requires(ItemTags.STONE_CRAFTING_MATERIALS).requires(Items.STRING).requires(Items.STICK).unlockedBy("has_stone", has(ItemTags.STONE_CRAFTING_MATERIALS)).save(consumer);
        ShapedRecipeBuilder.shaped(WABlocks.PLINTH.get().asItem()).pattern("#").pattern("S").pattern("Q").define('#', Blocks.STONE.asItem()).define('S', Blocks.SMOOTH_STONE.asItem()).define('Q', Blocks.QUARTZ_PILLAR).unlockedBy("has_crafting_table", has(Tags.Items.STONE)).save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(WABlocks.KONTRON_ORE.get().asItem()), WAItems.KONTRON_INGOT.get(), 0.7F, 300).unlockedBy("has_any_kontron", has(WABlocks.KONTRON_ORE.get().asItem())).save(consumer, new ResourceLocation(WeepingAngels.MODID, "smelt_kontron"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(WABlocks.KONTRON_ORE.get().asItem()), WAItems.KONTRON_INGOT.get(), 0.8F, 150).unlockedBy("has_any_kontron", has(WABlocks.KONTRON_ORE.get().asItem())).save(consumer, new ResourceLocation(WeepingAngels.MODID, "blast_kontron"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(WABlocks.KONTRON_ORE_DEEPSLATE.get().asItem()), WAItems.KONTRON_INGOT.get(), 0.7F, 300).unlockedBy("has_any_kontron", has(WABlocks.KONTRON_ORE.get().asItem())).save(consumer, new ResourceLocation(WeepingAngels.MODID, "smelt_kontron_deep"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(WABlocks.KONTRON_ORE_DEEPSLATE.get().asItem()), WAItems.KONTRON_INGOT.get(), 0.8F, 150).unlockedBy("has_any_kontron", has(WABlocks.KONTRON_ORE.get().asItem())).save(consumer, new ResourceLocation(WeepingAngels.MODID, "blast_kontron_deep"));
    }

}