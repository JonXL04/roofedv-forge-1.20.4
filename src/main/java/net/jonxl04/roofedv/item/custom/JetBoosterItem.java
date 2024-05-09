package net.jonxl04.roofedv.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class JetBoosterItem extends Item {
    public JetBoosterItem(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if(!pLevel.isClientSide()) {
            pPlayer.getCooldowns().addCooldown(this, 20);
            pPlayer.hurtMarked=true;
            pPlayer.addDeltaMovement(
                    pPlayer.getViewVector(1)
                    .multiply(1,
                            1,
                            1)
            );
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
