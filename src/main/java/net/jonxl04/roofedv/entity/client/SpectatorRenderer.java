package net.jonxl04.roofedv.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.entity.custom.SpectatorEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpectatorRenderer extends GeoEntityRenderer<SpectatorEntity> {
    public SpectatorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SpectatorModel());
    }

    @Override
    public ResourceLocation getTextureLocation(SpectatorEntity animatable) {
        return new ResourceLocation(RoofedVMod.MOD_ID, "textures/entity/spectator.png");
    }

    @Override
    public void render(SpectatorEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
