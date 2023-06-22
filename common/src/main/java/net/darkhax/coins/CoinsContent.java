package net.darkhax.coins;

import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.function.CachedSupplier;
import net.darkhax.bookshelf.api.registry.RegistryDataProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.entity.BannerPattern;

public final class CoinsContent extends RegistryDataProvider {

    public static final String MOD_ID = "coinsje";

    private final TagKey<BannerPattern> bannerTag = Services.TAGS.bannerPatternTag(new ResourceLocation(MOD_ID, "pattern_item/coin_patterns"));

    public static void init() {

        Services.REGISTRIES.loadContent(new CoinsContent());
    }

    private CoinsContent() {

        super(MOD_ID);

        this.withItemTab(() -> BuiltInRegistries.ITEM.get(new ResourceLocation(MOD_ID, "gold_coin_pile")).getDefaultInstance());

        this.registerCoinTier("copper");
        this.registerCoinTier("iron");
        this.registerCoinTier("gold");
        this.registerCoinTier("diamond");
        this.registerCoinTier("netherite");

        this.items.add(() -> new BannerPatternItem(bannerTag, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)), "coin_pattern");
        this.bannerPatterns.add(() -> new BannerPattern(MOD_ID + "_greyscale_coin_pile"), "greyscale_coin_pile");
    }

    private void registerCoinTier(String tierName) {

        this.items.add(() -> new Item(new Item.Properties()), tierName + "_coin");
        this.items.add(() -> new Item(new Item.Properties()), tierName + "_coin_pile");
        this.bannerPatterns.add(() -> new BannerPattern(MOD_ID + "_" + tierName + "_coin_pile"), tierName + "_coin_pile");
    }
}