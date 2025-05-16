package net.rngaming.structure.nature.world.village;

import net.minecraft.util.Identifier;
import net.rngaming.structure.nature.StructureNature;
import net.rngaming.structure.nature.impl.FabricStructurePoolRegistry;


public class VillageAdditions {
    public static void registerVillager() {
        FabricStructurePoolRegistry.registerSimple(
                Identifier.of("minecraft:village/plains/houses"),
                Identifier.of(StructureNature.MOD_ID, "stach"),
                120
        );
    }
}
