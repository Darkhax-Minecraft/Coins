# [Coins](https://minecraft.curseforge.com/projects/coins-je)

This mod adds several types of coins which can be used for decoraton, quest, role play, and economy systems. There are five tiers of coins. Players can get gold and iron coins by smelting gold and iron ingots in a furnace. This will give you one coin of the respective tier.

## Coin Tiers
![Coin Tiers](https://media.forgecdn.net/attachments/287/416/coin_tiers.png "The tiers of coins and how they convert.")

## Coin Conversion Recipes
![Coin Conversion Recipes](https://media.forgecdn.net/attachments/287/418/upcraft.gif "Conversion recipes for the types of coins.")

## Coin Stack Recipes
![Coin Stack Recipes](https://media.forgecdn.net/attachments/287/417/pile_craft.gif "Coin Stacking Recipes")

## Banner Patterns
Players can craft banner patterns using paper, shears, and a pile of coins. The banner will use the exact texture of the item when applied with white dye. This recipe will consume the coins item and damage the durability of the shears. Using other dye colors will work, but the color might not be what you expect. For vanilla-like colors you should use the generic pattern.
![Banner Designs](https://media.forgecdn.net/attachments/336/11/banner_patterns.png "The copper, iron, gold, platinum, and diamond banners.")

Additionally players can craft a generic version of the pattern by putting any non-generic coin pattern in the crafting table. The generic version has no predefined color palette and can be used to get different colors of the design which better resemble the vanilla wool/dye colors.
![Generic Pattern](https://media.forgecdn.net/attachments/336/12/generic_pattern.png "Generic coin pattern in the 16 vanilla colors.") 

### Why the Generic pattern?
The specific coin tier patterns preserve the palette of the original item. This means that using a dye will combine that color with the original palette, creating new color options. For example diamond has a blueish palette, so using a yellow dye will make a green coin. These combinations can be fun however the generic pattern will allow for more traditional dye colors.

## Maven Dependency
If you are using [Gradle](https://gradle.org) to manage your dependencies, add the following into your `build.gradle` file. Make sure to replace the version with the correct one. All versions can be viewed [here](https://maven.blamejared.com/net/darkhax/coins/).
```
repositories {

    maven {
    
        url 'https://maven.blamejared.com'
    }
}

dependencies {

    // Example: compile "net.darkhax.coins:Coins-1.16.4:5.0.2"
    compile "net.darkhax.coins:Coins-MCVERSION:PUT_FILE_VERSION_HERE"
}
```

## Jar Signing

As of January 11th 2021 officially published builds will be signed. You can validate the integrity of these builds by comparing their signatures with the public fingerprints.

| Hash   | Fingerprint                                                        |
|--------|--------------------------------------------------------------------|
| MD5    | `12F89108EF8DCC223D6723275E87208F`                                 |
| SHA1   | `46D93AD2DC8ADED38A606D3C36A80CB33EFA69D1`                         |
| SHA256 | `EBC4B1678BF90CDBDC4F01B18E6164394C10850BA6C4C748F0FA95F2CB083AE5` |


## Sponsors
<img src="https://nodecraft.com/assets/images/logo-dark.png" width="384" height="90">

This project is sponsored by Nodecraft. Use code [Darkhax](https://nodecraft.com/r/darkhax) for 30% off your first month of service!

	