package net.zbound.architecturytest.fabric;

import net.zbound.architecturytest.ArchitecturyTest;
import net.fabricmc.api.ModInitializer;

public final class ArchitecturyTestFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        ArchitecturyTest.init();
    }
}
