package com.championash5357.tutorial.block;

import com.championash5357.tutorial.client.gui.object.InteractionObjectStorage;
import com.championash5357.tutorial.tileentity.TileEntityStorage;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockStorage extends Block {

	public BlockStorage() {
		super(Properties.create(Material.ROCK));
		this.setRegistryName("storage");
	}
	
	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote && player instanceof EntityPlayerMP) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if(tile instanceof TileEntityStorage)
				NetworkHooks.openGui((EntityPlayerMP) player, new InteractionObjectStorage((TileEntityStorage) tile), (buffer) -> {
					buffer.writeBlockPos(pos);
				});
		}
		return true;
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
