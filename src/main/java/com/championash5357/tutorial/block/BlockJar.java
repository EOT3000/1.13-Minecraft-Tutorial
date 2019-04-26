package com.championash5357.tutorial.block;

import com.championash5357.tutorial.tileentity.TileEntityJar;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockJar extends Block {

	public BlockJar() {
		super(Properties.create(Material.GLASS).hardnessAndResistance(.2f));
		setRegistryName("jar");
	}
	
	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityJar jar = (TileEntityJar) worldIn.getTileEntity(pos);
		if(jar.amount() < 20 && !player.getHeldItem(hand).isEmpty() && !player.isSneaking() && player.getHeldItem(hand).getItem().equals(Items.COOKIE)) {
			player.getHeldItem(hand).shrink(1);
			jar.addCookie();
			return true;
		} else if(player.isSneaking() && jar.amount() > 0){
			player.addItemStackToInventory(new ItemStack(Items.COOKIE));
			jar.removeCookie();
			return true;
		}
		return false;
	}
	
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te, ItemStack stack) {
		TileEntityJar jar = (TileEntityJar) te;
		while(jar.amount() > 0) {
			if(!worldIn.isRemote) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.COOKIE)));
			jar.removeCookie();
		}
		super.harvestBlock(worldIn, player, pos, state, te, stack);
	}
	
	@Override
	public boolean isBlockNormalCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		return Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
		return new TileEntityJar();
	}
}
