package net.jonxl04.roofedv.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SlashParticle$Factory implements ParticleProvider<SimpleParticleType> {
    private final SpriteSet sprite;

    public SlashParticle$Factory(SpriteSet p_107092_) {
        this.sprite = p_107092_;
    }

    public Particle createParticle(SimpleParticleType pLevel, ClientLevel pClientLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        SlashParticle slashParticle = new SlashParticle(pClientLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprite);
        return slashParticle;
    }
}
