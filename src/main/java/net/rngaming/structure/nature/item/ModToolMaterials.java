package net.rngaming.structure.nature.item;

import net.minecraft.registry.tag.BlockTags;
import net.rngaming.structure.nature.util.ModTags;
import net.minecraft.item.ToolMaterial;


public class ModToolMaterials {
    public static ToolMaterial MAGIC = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            3000, 10.0F, 10.0F, 18, ModTags.Items.MAGIC_SHARD_REPAIR);
}
