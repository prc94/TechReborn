package techreborn.items.tools;

import ic2.api.item.IElectricItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import techreborn.client.TechRebornCreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRockCutter extends ItemPickaxe implements IElectricItem{
	
	public int maxCharge = 10000;
    public int cost = 500;
    public int tier = 2;

	public ItemRockCutter(ToolMaterial toolMaterial) 
	{
		super(toolMaterial);
		setUnlocalizedName("techreborn.rockcutter");
		setCreativeTab(TechRebornCreativeTab.instance);
		setMaxStackSize(1);
        setMaxDamage(27);
        efficiencyOnProperMaterial = 16F;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) 
	{
		this.itemIcon = iconRegister.registerIcon("techreborn:" + "rockcutter");
	}
	
	 @Override
	 public boolean canHarvestBlock(Block block, ItemStack stack) 
	 {
		 return Items.diamond_pickaxe.canHarvestBlock(block, stack);
	 }
	 
	 @Override
	 public boolean isRepairable() 
	 {
		 return false;
	 }
	 
	 public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	 {
	    par1ItemStack.addEnchantment(Enchantment.silkTouch, 1);    
	 }
	 
	 
	@Override
	public boolean canProvideEnergy(ItemStack itemStack) 
	{
		return false;
	}

	@Override
	public Item getChargedItem(ItemStack itemStack) 
	{
		return this;
	}

	@Override
	public Item getEmptyItem(ItemStack itemStack) 
	{
		return this;
	}

	@Override
	public double getMaxCharge(ItemStack itemStack) 
	{
		return maxCharge;
	}

	@Override
	public int getTier(ItemStack itemStack) 
	{
		return tier;
	}

	@Override
	public double getTransferLimit(ItemStack itemStack) 
	{
		return 300;
	}

}
