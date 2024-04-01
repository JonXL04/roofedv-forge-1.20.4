package net.jonxl04.roofedv.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class SlashParticle extends TextureSheetParticle {
    private final SpriteSet sprites;
    private float rotation;

    protected SlashParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);

        this.sprites = pSprites;
        this.friction = 1.0f;
        this.xd *= pXSpeed * 0D;
        this.yd *= pYSpeed * 0D;
        this.zd *= pZSpeed * 0D;
        this.quadSize *= 8.0f;
        this.lifetime = 6;
        this.rotation = (float)Math.toRadians(this.random.nextInt(0,360));
        this.roll = this.rotation;
        this.setSpriteFromAge(pSprites);

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.roll = 0;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
        }
    }



    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    public static record Provider(SpriteSet sprites) implements ParticleProvider<SimpleParticleType> {
        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel world, double x, double y, double z, double velX, double velY, double velZ) {
            return new SlashParticle(world, x, y, z, velX, velY, velZ, this.sprites);
        }

        public SpriteSet sprites() {
            return this.sprites;
        }
    }
}
