package net.lallethu.lethuscommands.blocks;

import net.lallethu.lethuscommands.LethusCommands;
import net.lallethu.lethuscommands.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, LethusCommands.MOD_ID);

	public static final RegistryObject<Block> ONYX_BLOCK = registerBlock("onyx_block",
			() -> new Block(BlockBehaviour
					.Properties.of(Material.METAL)
					.strength(7f)
					.requiresCorrectToolForDrops()),
			CreativeModeTab.TAB_MISC);

	public static final RegistryObject<Block> ONYX_ORE = registerBlock("onyx_ore",
			() -> new Block(BlockBehaviour
					.Properties.of(Material.STONE)
					.strength(5f)
					.requiresCorrectToolForDrops()),
			CreativeModeTab.TAB_MISC);

	public static final RegistryObject<Block> ONYX_DEEPSLATE_ORE = registerBlock("onyx_deepslate_ore",
			() -> new Block(BlockBehaviour
					.Properties.of(Material.STONE)
					.strength(6f)
					.requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)),
			CreativeModeTab.TAB_MISC);

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn, tab);
		return toReturn;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
		return ModItems.ITEMS.register(name,
				() -> new BlockItem(block.get(),
						new Item.Properties().tab(tab)));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
