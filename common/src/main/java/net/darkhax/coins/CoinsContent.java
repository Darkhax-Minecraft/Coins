package net.darkhax.coins;

import net.darkhax.bookshelf.Constants;
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
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class CoinsContent extends RegistryDataProvider {

    public static final String MOD_ID = "coinsje";

    private final TagKey<BannerPattern> bannerTag = TagKey.create(Registries.BANNER_PATTERN, new ResourceLocation(MOD_ID, "pattern_item/coin_patterns"));

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

        // Alternative coins provided for users to customize
        this.registerAltCoinTier("zinc");
        this.registerAltCoinTier("brass");
        this.registerAltCoinTier("amethyst");
        this.registerAltCoinTier("redstone");
        this.registerAltCoinTier("lapis");
        this.registerAltCoinTier("emerald");
        this.registerAltCoinTier("ender");
        this.registerAltCoinTier("blazing");
        this.registerAltCoinTier("echo");
        this.registerAltCoinTier("prismarine");
        this.registerAltCoinTier("quartz");
    }

    private void registerCoinTier(String tierName) {

        this.items.add(() -> new Item(new Item.Properties()), tierName + "_coin");
        this.items.add(() -> new Item(new Item.Properties()), tierName + "_coin_pile");
        this.bannerPatterns.add(() -> new BannerPattern(MOD_ID + "_" + tierName + "_coin_pile"), tierName + "_coin_pile");
    }

    private void registerAltCoinTier(String tierName) {

        this.items.add(() -> new Item(new Item.Properties()), tierName + "_coin");
        this.items.add(() -> new Item(new Item.Properties()), tierName + "_coin_pile");

        final File output = new File("output");
        output.mkdir();

        final File recipes = new File(output, "recipes");
        recipes.mkdir();

        try (FileWriter writer = new FileWriter(new File(recipes, "stack_" + tierName + "_pile.json"))) {
            writer.append("{\n" +
                    "  \"type\": \"minecraft:crafting_shaped\",\n" +
                    "  \"group\": \"coin_pile\",\n" +
                    "  \"pattern\": [\n" +
                    "    \"XXX\",\n" +
                    "    \"XXX\",\n" +
                    "    \"XXX\"\n" +
                    "  ],\n" +
                    "  \"key\": {\n" +
                    "    \"X\": {\n" +
                    "      \"item\": \"coinsje:" + tierName + "_coin\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"coinsje:" + tierName + "_coin_pile\"\n" +
                    "  }\n" +
                    "}");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(new File(recipes, "deconstruct_" + tierName + "_pile.json"))) {
            writer.append("{\n" +
                    "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                    "  \"group\": \"coins\",\n" +
                    "  \"ingredients\": [\n" +
                    "    {\n" +
                    "      \"item\": \"coinsje:" + tierName + "_coin_pile\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"result\": {\n" +
                    "    \"item\": \"coinsje:" + tierName + "_coin\",\n" +
                    "    \"count\": 9\n" +
                    "  }\n" +
                    "}");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        final File models = new File(output, "models");
        models.mkdir();

        try (FileWriter writer = new FileWriter(new File(models, tierName + "_coin.json"))) {
            writer.append("{\n" +
                    "    \"parent\": \"item/generated\",\n" +
                    "    \"textures\": {\n" +
                    "        \"layer0\": \"coinsje:item/" + tierName + "_coin\"\n" +
                    "    }\n" +
                    "}");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(new File(models, tierName + "_coin_pile.json"))) {
            writer.append("{\n" +
                    "    \"parent\": \"item/generated\",\n" +
                    "    \"textures\": {\n" +
                    "        \"layer0\": \"coinsje:item/"+ tierName + "_coin_pile\"\n" +
                    "    }\n" +
                    "}");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        Constants.LOG.info("  \"item.coinsje." + tierName + "_coin\": \""+ StringUtils.capitalize(tierName) + " Coin\",");
        Constants.LOG.info("  \"item.coinsje." + tierName + "_coin_pile\": \""+ StringUtils.capitalize(tierName) + " Coin Pile\",");
    }
}