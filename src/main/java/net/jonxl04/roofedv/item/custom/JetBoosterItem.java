package net.jonxl04.roofedv.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class JetBoosterItem extends Item {
    public JetBoosterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {

        }


        return InteractionResult.SUCCESS;
    }
}
