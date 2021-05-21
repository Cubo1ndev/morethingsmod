package net.more.things.entities.rainbow_sheep;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.more.things.entities.base.BaseMonoColorSheepEntity;
import net.more.things.sounds.MoreThingsSounds;

public class RainbowSheepEntity extends BaseMonoColorSheepEntity<RainbowSheepEntity> {

    public RainbowSheepEntity(EntityType<? extends RainbowSheepEntity> type, World world) {
        super(type, world, new ItemStack(Blocks.WHITE_WOOL));
    }

    protected SoundEvent getAmbientSound() {
        return MoreThingsSounds.RAINBOW_SHEEP_AMBIENT_SOUND;
    }

    protected SoundEvent getDeathSound() {
        return MoreThingsSounds.RAINBOW_SHEEP_DEATH_SOUND;
    }

}
