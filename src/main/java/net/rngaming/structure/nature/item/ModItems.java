package net.rngaming.structure.nature.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.rngaming.structure.nature.StructureNature;


public class ModItems {
    public static final Item MAGIC_SHARD = registerItem("magic_shard",
            new Item(new Item.Settings().fireproof().rarity(Rarity.COMMON)));

    public static final Item MAGIC_GEM = registerItem("magic_gem",
            new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));

    private static void addItemToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(MAGIC_SHARD);
        entries.add(MAGIC_GEM);
    }

    public static final Item MAGIC_SWORD = registerItem("magic_sword",
            new SwordItem(ModToolMaterials.MAGIC, new Item.Settings().rarity(Rarity.EPIC).fireproof().attributeModifiers(SwordItem.createAttributeModifiers(
                    ModToolMaterials.MAGIC, 15, -3.2F
            ))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(StructureNature.MOD_ID, name), item);
    }

    public static void registerModItems() {
        StructureNature.LOGGER.info("Registering and Loading Items for " + StructureNature.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientTabItemGroup);
    }
}
