# Hypu - Dreams Of The Past

A top-down 2D action RPG written in Java with Swing. You play as Hypu, explore a pixel art world, fight slimes, collect gear, trade with merchants, and try to find out what happened to Lexis.

The game is in early development. The latest patch is 0.18.

## Features

- Melee combat with knockback
- Weapons that fire projectiles and use mana (Blade of the Abyss, Blade of Volteris)
- Leveling with stats for life, attack, ability power, armor and magic resist
- Inventory and equipment screen with stackable items
- Trading with the merchant Lila
- NPCs with dialogue and pathfinding
- Four slime types: Green, Blue, Red and Corefire
- Destroyable bushes and rocks, with particles
- Day, dusk and night lighting, plus a lantern and a tent for sleeping
- Healing pool and portals between maps
- Options menu with full screen, music volume and sound effect volume, saved to `Config.txt`
- Game over screen with retry

## Controls

| Key  | Action                 |
|------|------------------------|
| WASD | Move / navigate menus  |
| X    | Confirm, talk, interact|
| Q    | Attack                 |
| F    | Cast ability           |
| C    | Status and inventory   |
| P    | Pause                  |
| ESC  | Options                |

## Requirements

- Java JDK 23 or newer (developed on JDK 23, also tested on JDK 24)

## Running the game

### Eclipse

1. Import `Hypu - Dreams Of The Past Code/Main` as an existing project.
2. Delete or exclude `src/snippet/Snippet.java`. It is an empty leftover file and does not compile.
3. Run `main.Main`.

### Command line

From the `Hypu - Dreams Of The Past Code/Main` folder:

```bash
javac -d out $(find src -name "*.java" ! -path "*/snippet/*")
```

```bash
cp -R res/ out/
```

```bash
java -cp out main.Main
```

Run the game from the `Main` folder. Settings are read from and saved to `Config.txt` in the folder you run it from.

`Config.txt` has three lines:

```
On     full screen (On or Off)
2      music volume (0 to 5)
3      sound effect volume (0 to 5)
```

## Project structure

```
Hypu - Dreams Of The Past Code/Main/
  src/
    main/              game loop, UI, input, sound, events, config
    entity/            player, NPCs, projectiles, particles
    monster/           slimes
    object/            items, weapons, shields, doors, chests
    tile/              tile and map loading
    tile_interactive/  destroyable tiles
    environment/       lighting and day/night cycle
    ai/                pathfinding
  res/                 sprites, maps, sounds, fonts
Characters/            character art
Maps/                  map source files
Monsters/              monster art and lore
Objects/, Weapons/, Projectiles/, TileBlocks/, Sounds/, Fonts/   source assets
Patch Notes/           patch notes and dev log
```

## Known limitations

- Load Game and Settings on the title screen do nothing yet. Use ESC in game for settings.
- The difficulty screen is shown, but every option starts the same game.
- There is no save system yet.

## Planned

- Lightning item
- Map screen and minimap
- New monsters
- Advanced combat with guard and parry
- Animated tiles
- Blade of the Abyss rework
