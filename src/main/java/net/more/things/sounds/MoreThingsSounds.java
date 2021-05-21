package net.more.things.sounds;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreThingsSounds {
	public static final SoundEvent PLUMAGAY_SOUND = new SoundEvent(new Identifier("morethings","pluma_gay"));
	public static final SoundEvent RAINBOW_SHEEP_DEATH_SOUND = new SoundEvent(new Identifier("morethings","entity.rainbow_sheep.death"));
	public static final SoundEvent RAINBOW_SHEEP_AMBIENT_SOUND = new SoundEvent(new Identifier("morethings","entity.rainbow_sheep.ambient"));
    
    public static void registerSounds() {
		Registry.register(Registry.SOUND_EVENT, new Identifier("morethings","pluma_gay"), PLUMAGAY_SOUND);
		Registry.register(Registry.SOUND_EVENT, new Identifier("morethings","entity.rainbow_sheep.death"), RAINBOW_SHEEP_DEATH_SOUND);
		Registry.register(Registry.SOUND_EVENT, new Identifier("morethings","entity.rainbow_sheep.ambient"), RAINBOW_SHEEP_AMBIENT_SOUND);
    }
}
