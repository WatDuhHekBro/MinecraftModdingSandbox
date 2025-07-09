package net.zbound.architecturytest.forge;

import net.zbound.architecturytest.ArchitecturyTest;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ArchitecturyTest.MOD_ID)
public final class ArchitecturyTestForge {
    public ArchitecturyTestForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(ArchitecturyTest.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        ArchitecturyTest.init();
    }
}
