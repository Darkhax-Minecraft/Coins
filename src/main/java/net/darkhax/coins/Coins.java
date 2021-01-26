package net.darkhax.coins;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.darkhax.bookshelf.item.ItemGroupBase;
import net.darkhax.bookshelf.registry.RegistryHelper;
import net.minecraft.item.BannerPatternItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.tileentity.BannerPattern;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("coins")
public class Coins {
    
    private final Logger log = LogManager.getLogger("Coins");
    private final RegistryHelper registry = new RegistryHelper("coins", this.log).withItemGroup(new ItemGroupBase("coins", this::createTabIcon));
    
    private final Item tabIconItem;
    
    public Coins() {
        
        this.createSimpleItem("coin_copper");
        this.createSimpleItem("coin_iron");
        this.createSimpleItem("coin_gold");
        this.createSimpleItem("coin_platinum");
        this.createSimpleItem("coin_diamond");
        
        this.createSimpleItem("coin_pile_copper");
        this.createSimpleItem("coin_pile_iron");
        this.tabIconItem = this.createSimpleItem("coin_pile_gold");
        this.createSimpleItem("coin_pile_platinum");
        this.createSimpleItem("coin_pile_diamond");
        
        registerItemPattern("pile_copper", Rarity.UNCOMMON);
        registerItemPattern("pile_iron", Rarity.UNCOMMON);
        registerItemPattern("pile_gold", Rarity.UNCOMMON);
        registerItemPattern("pile_platinum", Rarity.UNCOMMON);
        registerItemPattern("pile_diamond", Rarity.UNCOMMON);
        registerItemPattern("pile_grayscale", Rarity.COMMON);
        
        this.registry.initialize(FMLJavaModLoadingContext.get().getModEventBus());
    }
    
    private Item createSimpleItem (String id) {
        
        return this.registry.items.register(new Item(new Properties()), id);
    }
    
    /**
     * TODO Remove in 1.17
     */
    public void registerItemPattern (String id, Rarity rarity) {
        
        final BannerPattern pattern = registry.banners.registerPattern(id, true);
        registry.items.register(new BannerPatternItem(pattern, new Item.Properties().maxStackSize(1).rarity(rarity)), id + "_banner_pattern");
    }
    
    private final ItemStack createTabIcon () {
        
        return new ItemStack(this.tabIconItem);
    }
}