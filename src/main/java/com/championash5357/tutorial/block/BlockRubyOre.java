package com.championash5357.tutorial.block;

import com.championash5357.tutorial.init.TutorialItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockRubyOre extends Block {

	public BlockRubyOre() {
		super(Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(3.0F, 2.0F).lightValue(8).sound(SoundType.SLIME).slipperiness(.2F));
		this.setRegistryName("ruby_ore");
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return 2;
	}
	
	@Override
	public ToolType getHarvestTool(IBlockState state) {
		return ToolType.AXE;
	}
	
	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		drops.add(new ItemStack(TutorialItems.RUBY, 1 + fortune));
	}
}
