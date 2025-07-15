package net.rngaming.structure.nature.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.rngaming.structure.nature.StructureNature;

import java.util.function.Function;

public class ModBlocks {
    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            properties -> new Block(properties.strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block MAGIC_STONE = registerBlock("magic_stone",
            properties -> new Block(properties.strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));



    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(StructureNature.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(StructureNature.MOD_ID, name), toRegister);
    }


    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(StructureNature.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(StructureNature.MOD_ID, name)))));
    }


    public static void registerModBlocks() {
        StructureNature.LOGGER.info("Registering and Loading Blocks for " + StructureNature.MOD_ID);
    }
}
