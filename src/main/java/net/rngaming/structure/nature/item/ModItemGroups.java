package net.rngaming.structure.nature.item;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.EnchantedBookItem;
import net.rngaming.structure.nature.StructureNature;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rngaming.structure.nature.blocks.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup STRUCTURE_NATURE = Registry.register(Registries.ITEM_GROUP,
             Identifier.of(StructureNature.MOD_ID, "magic_shard"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.structure"))
                    .icon(() -> new ItemStack(ModItems.MAGIC_SHARD)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MAGIC_SHARD);
                        entries.add(ModItems.MAGIC_GEM);

                        

                        entries.add(ModItems.MAGIC_SWORD);

                        entries.add(ModBlocks.MAGIC_BLOCK);


                    }).build());


    public static void registerItemGroups() {
        StructureNature.LOGGER.info("Registering and Loading Item Groups for " + StructureNature.MOD_ID);
    }
}