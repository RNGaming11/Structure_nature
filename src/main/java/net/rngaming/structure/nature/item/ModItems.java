package net.rngaming.structure.nature.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.rngaming.structure.nature.StructureNature;

import java.util.function.Function;


public class ModItems {
    public static final Item MAGIC_SHARD = registerItem("magic_shard",
            setting -> new Item(setting.rarity(Rarity.RARE).fireproof()));

    public static final Item MAGIC_GEM = registerItem("magic_gem",
            setting -> new Item(setting.rarity(Rarity.RARE).fireproof()));

    private static void addItemToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(MAGIC_SHARD);
        entries.add(MAGIC_GEM);
    }

    public static final Item MAGIC_SWORD = registerItem("magic_sword",
            setting -> new Item(setting.sword(ModToolMaterials.MAGIC, 15, -3f).fireproof().rarity(Rarity.EPIC)));



    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(StructureNature.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(StructureNature.MOD_ID, name)))));
    }

    public static void registerModItems() {
        StructureNature.LOGGER.info("Registering and Loading Items for " + StructureNature.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientTabItemGroup);
    }
}
