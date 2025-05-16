package net.rngaming.structure.nature.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.rngaming.structure.nature.blocks.ModBlocks;
import net.rngaming.structure.nature.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> MAGIC_SMELT = List.of(ModItems.MAGIC_SHARD,
            ModItems.MAGIC_GEM);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MAGIC_SHARD, RecipeCategory.MISC,
                ModBlocks.MAGIC_BLOCK);

        offerBlasting(exporter, MAGIC_SMELT, RecipeCategory.MISC, ModItems.MAGIC_GEM,
                82f, 20000, "magic");

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MAGIC_SWORD, 1)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .input('#', Items.STICK)
                .input('X', ModItems.MAGIC_GEM)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.MAGIC_GEM), conditionsFromItem(ModItems.MAGIC_GEM))
                .offerTo(exporter,  Identifier.of(getRecipeName(ModItems.MAGIC_SWORD)));
    }
}
