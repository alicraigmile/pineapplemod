package com.kaimoriginals.minecraft.pineapplemod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.kaimoriginals.minecraft.pineapplemod.PineapplemodModElements;

@PineapplemodModElements.ModElement.Tag
public class PineappleFoodEatenProcedure extends PineapplemodModElements.ModElement {
	public PineappleFoodEatenProcedure(PineapplemodModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PineappleFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel((int) 10);
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Pineapple Power!"), (true));
		}
	}
}
