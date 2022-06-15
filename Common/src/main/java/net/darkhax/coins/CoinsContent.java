package net.darkhax.coins;

import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.function.CachedSupplier;
import net.darkhax.bookshelf.api.registry.RegistryDataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public final class CoinsContent extends RegistryDataProvider {

    public static final String MOD_ID = "coinsje";

    public static void init() {

        Services.REGISTRIES.loadContent(new CoinsContent());
    }

    private CoinsContent() {

        super(MOD_ID);

        this.withCreativeTab(CachedSupplier.cache(() -> Services.REGISTRIES.items().get(new ResourceLocation(MOD_ID, "gold_coin_pile"))));

        this.registerCoinTier("copper");
        this.registerCoinTier("iron");
        this.registerCoinTier("gold");
        this.registerCoinTier("diamond");
        this.registerCoinTier("netherite");
    }

    private void registerCoinTier(String tierName) {

        this.items.add(() -> new Item(new Item.Properties()), tierName + "_coin");
        this.items.add(() -> new Item(new Item.Properties()), tierName + "_coin_pile");
    }
}