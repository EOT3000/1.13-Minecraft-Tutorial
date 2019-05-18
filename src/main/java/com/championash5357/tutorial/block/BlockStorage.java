package com.championash5357.tutorial.block;

import com.championash5357.tutorial.tileentity.TileEntityStorage;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockStorage extends Block {

	public BlockStorage() {
		super(Properties.create(Material.ROCK));
		this.setRegistryName("storage");
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
		return new TileEntityStorage();
	}
}
