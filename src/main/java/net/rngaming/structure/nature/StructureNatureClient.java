package net.rngaming.structure.nature;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.rngaming.structure.nature.blocks.ModBlocks;

public class StructureNatureClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
    }

    public static void registerPlayerClient() {
        StructureNature.LOGGER.info("Getting World files for " + StructureNature.MOD_ID);
        StructureNature.LOGGER.info("Loading Structures from " + StructureNature.MOD_ID);
    }
}
