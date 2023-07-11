package net.lallethu.lethuscommands;

import com.mojang.logging.LogUtils;
import net.lallethu.lethuscommands.blocks.ModBlocks;
import net.lallethu.lethuscommands.items.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LethusCommands.MOD_ID)
public class LethusCommands {
	public static final String MOD_ID = "lethuscommands";
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();

	public LethusCommands() {
		// Register items and block from mod by using the eventBus interface
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModItems.register(eventBus);
		ModBlocks.register(eventBus);
		eventBus.addListener(this::setup);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("HELLO FROM PREINIT");
		LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
	}
}
