
package com.kaimoriginals.minecraft.pineapplemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import java.util.Map;
import java.util.HashMap;

import com.kaimoriginals.minecraft.pineapplemod.procedures.PineappleFoodEatenProcedure;
import com.kaimoriginals.minecraft.pineapplemod.PineapplemodModElements;

@PineapplemodModElements.ModElement.Tag
public class PineappleItem extends PineapplemodModElements.ModElement {
	@ObjectHolder("pineapplemod:pineapple")
	public static final Item block = null;
	public PineappleItem(PineapplemodModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("pineapple");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				PineappleFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
