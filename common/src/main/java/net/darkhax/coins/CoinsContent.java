package net.darkhax.coins;

import net.darkhax.bookshelf.common.api.function.CachedSupplier;
import net.darkhax.bookshelf.common.api.registry.ContentProvider;
import net.darkhax.bookshelf.common.api.registry.adapters.GameRegistryAdapter;
import net.darkhax.bookshelf.common.impl.registry.adapter.CreativeModeTabAdapter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public final class CoinsContent implements ContentProvider {

    public static final String MOD_ID = "coinsje";
    private static final CachedSupplier<ItemStack> TAB_ICON = CachedSupplier.cache(() -> BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(MOD_ID, "gold_coin_pile")).getDefaultInstance());

    @Override
    public void defineItems(GameRegistryAdapter<Item> registry) {
        // Primary coin tiers
        this.registerCoin(registry, "copper");
        this.registerCoin(registry, "iron");
        this.registerCoin(registry, "gold");
        this.registerCoin(registry, "diamond");
        this.registerCoin(registry, "netherite");

        // Alternative coins provided for users to customize
        this.registerCoin(registry, "zinc");
        this.registerCoin(registry, "brass");
        this.registerCoin(registry, "amethyst");
        this.registerCoin(registry, "redstone");
        this.registerCoin(registry, "lapis");
        this.registerCoin(registry, "emerald");
        this.registerCoin(registry, "ender");
        this.registerCoin(registry, "blazing");
        this.registerCoin(registry, "echo");
        this.registerCoin(registry, "prismarine");
        this.registerCoin(registry, "quartz");

        // Misc
        registry.add("coin_pattern", new BannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(MOD_ID, "pattern_item/coin_patterns")), new Item.Properties().stacksTo(1)));
    }

    private void registerCoin(GameRegistryAdapter<Item> registry, String tierName) {
        registry.add(tierName + "_coin", new Item(new Item.Properties()));
        registry.add(tierName + "_coin_pile", new Item(new Item.Properties()));
    }

    @Override
    public void defineCreativeTabs(CreativeModeTabAdapter registry) {
        registry.add("tab", TAB_ICON, (params, builder) -> {
        });
    }

    @Override
    public String namespace() {
        return MOD_ID;
    }
}