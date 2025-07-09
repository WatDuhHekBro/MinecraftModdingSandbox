# Minecraft Mod Idea

ZFactor: Plugin, a bit of development done
PaleGardenTest2: Fabric mod, minecraft:firefly_bush and minecraft:brown_egg
VanillaBackportCompat/PaleGardenTest/BackportCompatTest: Blank slates for the most part, failed

GOOD NEWS! There's nothing prevent a mod from registering "minecraft:" items/blocks which can be safely loaded in future versions that support those blocks. Moving forward is the intention (especially with an updated vanilla backport once you know it works). Moving backward doesn't inherently break (though I wouldn't count on it to work).



How to optionally require a mod? And optionally operate on that mod? Look at IDAS API.

How do you compile for multiple platforms (Forge/NeoForge/Fabric) and for multiple versions? Look at that one Epic Fight compat plugin for multiple versions. No, it was Distant Horizons (also on Gitlab).

How do you compile a single jar that works for many different mods? Look for those mods on Modrinth that have a single jar for multiple versions like BlueMap. Or some other plugin/mod hybrid, they've probably got some good examples.



https://modrinth.com/mod/distanthorizons/versions
https://gitlab.com/distant-horizons-team/distant-horizons
- v2.3.2 for Fabric/NeoForge 1.21.5
- v2.3.2 for Fabric/Forge 1.16.5

https://modrinth.com/plugin/bluemap/versions
https://github.com/BlueMap-Minecraft/BlueMap
- v5.7-neoforge for 1.21.x
- v5.7-forge for 1.21.x
- v5.7-fabric for 1.21.x

https://modrinth.com/plugin/viaversion/versions
https://github.com/ViaVersion/ViaVersion
- v5.4.0 for Fabric/Paper/Velocity/Folia 1.8.9 - 1.21.x

https://modrinth.com/mod/proxy-compatible-forge/versions
https://github.com/adde0109/Proxy-Compatible-Forge
- v1.1.7 for Forge/NeoForge 1.14.x - 1.21.4

https://modrinth.com/mod/no-telemetry/versions
https://github.com/kb-1000/no-telemetry
- v1.9.0 for Fabric/Forge/NeoForge/Quilt 1.18.x - 1.21.x



And maybe you could even operate on mods optionally like Quark's variants, turn them into "minecraft:chest" with variant data tags instead so those don't disappear if you want to remove Quark. In that case, it wouldn't just be a Backport Compatibility Layer.

JSON Method? 1.20.1.json, 1.20.2.json, etc. List of blocks/items added in each version, then adjust mappings accordingly. Then you can automatically register a list of blocks/items to register, if nothing else than to allow safely loading in newer versioned maps into an older version.
- For this JSON method, is there a way to dynamically load which blocks to put in the registry, or does it have to be done at compile-time? This might restrict what the user can expect (their customization of mods like Quark).

"Vanilla Compatibility Layer" --> Implies compatibility with Vanilla. Maybe "Future Vanilla Compatibility Layer"

Another stated goal of this mod will be to essentially prevent future blocks/items from getting deleted, whether it's via removing a backport mod, or loading a newer world in an older version. Sure, there might be missing textures, but the data will still be there depending on what version or mod you load in.



# Architectury Mod (June 2)

Minecraft Architectury Mod: Minecraft namespace for blocks and items. Key feature is that it retains vanilla items even in past versions and read those blocks correctly. Future-Safe Backport Compatibility Layer

First step is to successfully load and not delete the blocks/items with missing texture. Mods can be optionally referenced to add those missing textures and functionality, so you're not stuck on one specific backport mod.

Or maybe a suite of tools to scan chunks for modded items/blocks, then ask you to decide (in a bulk list) what to do with each?

Simply register a mod ID of "minecraft" instead of your actual mod ID.

Main Use Case (start on 1.20.1): Use backport mods and be able to update your vanilla version and have all those backported items/blocks transfer over to vanilla seamlessly.
- Reap the benefits of a stable modded version with the future-safe compatibility layer on top of vanilla backport mods. Get both 1.20.1 mods and modern vanilla features that will be safe to update.
- Big mods can't reasonably be expected to update beyond chosen versions like 1.20.1 and 1.21.1, so vanilla backport mods will help fill in the gaps, especially with the new drop system.

Convert blocks/items from recognized mods and inject functionality into these blocks/items.

Extra worldgen changes mod if necessary (such as 1.20.2 diamond generation).

Version table on mod page noting which version is safe to update to which. v1.1 of the mod can safely handle 1.21.5 blocks/items.

On the readme should be an easy "how to update this mod" guide in case life happens.

-----

Vanilla Backport Mods (via Just Create SMP)
- Vanilla Backport
- Firefly Bush (https://www.curseforge.com/minecraft/mc-mods/firefly-bush)

Name: "Vanilla-Safe Backport Layer"

-----

Vanilla Backport Compatibility Layer
- Mainly just set "minecraft:blue_egg" to "somemodid:blue_egg" and have the mod automatically figure it out / redirect it somehow. This allows passing functionality over to whatever backend you choose.
