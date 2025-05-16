package net.rngaming.structure.nature.world.dimension;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.rngaming.structure.nature.StructureNature;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> MAGIC_DIM_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(StructureNature.MOD_ID, "magic_dim"));
    public static final RegistryKey<World> MAGIC_DIM_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(StructureNature.MOD_ID, "magic_dim"));
    public static final RegistryKey<DimensionType> MAGIC_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(StructureNature.MOD_ID, "magic_dim_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(MAGIC_DIM_TYPE, new DimensionType (
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                true, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                false, // bedWorks
                true, // respawnAnchorWorks
                32, // minY
                304, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD,
                DimensionTypes.OVERWORLD_ID,
                1.2f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
}
