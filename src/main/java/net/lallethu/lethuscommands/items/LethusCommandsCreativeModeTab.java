package net.lallethu.lethuscommands.items;

import net.lallethu.lethuscommands.blocks.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class LethusCommandsCreativeModeTab {
	public static CreativeModeTab LETHUS_TAB =
			new CreativeModeTab("Lethus") {
				@Override
				public ItemStack makeIcon() {
					return new ItemStack(ModBlocks.ONYX_ORE.get());
				}
			};

}
