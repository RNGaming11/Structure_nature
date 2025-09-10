package net.rngaming.structure.nature;

import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import net.rngaming.structure.nature.blocks.ModBlocks;
import net.rngaming.structure.nature.item.ModItemGroups;
import net.rngaming.structure.nature.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StructureNature implements ModInitializer {
	public static final String MOD_ID = "structure-nature";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading Structure nature Mod");

		LOGGER.info("Registering item groups");
		ModItemGroups.registerItemGroups();
		LOGGER.info("Item groups registered");

		LOGGER.info("Registering mod items");
		ModItems.registerModItems();
		LOGGER.info("Mod items registered");

		LOGGER.info("Registering mod blocks");
		ModBlocks.registerModBlocks();
		LOGGER.info("Mod blocks registered");

		registerMagicPortal();

		LOGGER.info("Applying Loaded Structure nature data");
		StructureNatureClient.registerPlayerClient();
		LOGGER.info("Loaded Structure nature");
	}

	private void registerMagicPortal() {
		LOGGER.info("Registring Magic Portal");
		Identifier portalId = Identifier.of(MOD_ID, "magic_dim");
			CustomPortalBuilder.beginPortal()
					.frameBlock(ModBlocks.MAGIC_STONE)
					.lightWithItem(ModItems.MAGIC_GEM)
					.destDimID(portalId)
					.registerPortal();
			LOGGER.info("Magic Portal registered successfully");
		}
	}