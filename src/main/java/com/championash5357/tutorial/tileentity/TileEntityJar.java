package com.championash5357.tutorial.tileentity;

import com.championash5357.tutorial.init.TutorialTileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityJar extends TileEntity {

	private int amount = 0;
	
	public TileEntityJar() {
		super(TutorialTileEntities.JAR);
	}

	@Override
	public void read(NBTTagCompound compound) {
		this.amount = compound.getInt("amount");
		super.read(compound);
	}
	
	@Override
	public NBTTagCompound write(NBTTagCompound compound) {
		compound.setInt("amount", amount);
		return super.write(compound);
	}
	
	@Override
	public NBTTagCompound getUpdateTag() {
		return this.write(new NBTTagCompound());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.read(pkt.getNbtCompound());
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(this.pos, 0, this.getUpdateTag());
	}
	
	public void addCookie() {
		amount++;
		markDirty();
	}
	
	public void removeCookie() {
		amount--;
		markDirty();
	}
	
	public int amount() {
		return amount;
	}
}
