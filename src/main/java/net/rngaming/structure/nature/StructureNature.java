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
		// Log mod initialization
		LOGGER.info("Initializing Structure Nature Mod");

		// Register item groups
		LOGGER.info("Registering item groups...");
		ModItemGroups.registerItemGroups();
		LOGGER.info("Item groups registered.");

		// Register items
		LOGGER.info("Registering mod items...");
		ModItems.registerModItems();
		LOGGER.info("Mod items registered.");

		// Register blocks
		LOGGER.info("Registering mod blocks...");
		ModBlocks.registerModBlocks();
		LOGGER.info("Mod blocks registered.");

		StructureNatureClient.registerPlayerClient();

		// Register portal
		registerPortalIfNeeded();
	}

	private void registerPortalIfNeeded() {
		Identifier portalId = Identifier.of(MOD_ID, "magic_dim");
			CustomPortalBuilder.beginPortal()
					.frameBlock(ModBlocks.MAGIC_BLOCK)
					.lightWithItem(ModItems.MAGIC_GEM)
					.destDimID(portalId)
					.registerPortal();
			LOGGER.info("Portal registered successfully.");
		}
	}