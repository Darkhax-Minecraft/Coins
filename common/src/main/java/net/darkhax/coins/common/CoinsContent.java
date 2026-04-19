package net.darkhax.coins.common;

import net.darkhax.bookshelf.common.api.function.CachedSupplier;
import net.darkhax.bookshelf.common.api.registry.ContentProvider;
import net.darkhax.bookshelf.common.impl.registry.adapter.CreativeModeTabAdapter;
import net.darkhax.bookshelf.common.impl.registry.adapter.ItemRegistryAdapter;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.function.UnaryOperator;

public final class CoinsContent implements ContentProvider {

    public static final String MOD_ID = "coinsje";
    private static final CachedSupplier<ItemStack> TAB_ICON = CachedSupplier.cache(() -> BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath(MOD_ID, "gold_coin_pile")).getDefaultInstance());
    private static final TagKey<BannerPattern> TAG = TagKey.create(Registries.BANNER_PATTERN, Identifier.fromNamespaceAndPath(MOD_ID, "pattern_item/coin_patterns"));

    @Override
    public void defineItems(ItemRegistryAdapter registry) {

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

        registry.addSimple("coin_pattern", props -> props.stacksTo(1).rarity(Rarity.UNCOMMON).delayedComponent(DataComponents.PROVIDES_BANNER_PATTERNS, ctx -> ctx.getOrThrow(TAG)));
    }

    private void registerCoin(ItemRegistryAdapter registry, String tierName) {
        registry.addSimple(tierName + "_coin", UnaryOperator.identity());
        registry.addSimple(tierName + "_coin_pile", UnaryOperator.identity());
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