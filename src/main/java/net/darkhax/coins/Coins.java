package net.darkhax.coins;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.darkhax.bookshelf.item.ItemGroupBase;
import net.darkhax.bookshelf.registry.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemStack;
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
        
        this.registry.initialize(FMLJavaModLoadingContext.get().getModEventBus());
    }
    
    private Item createSimpleItem (String id) {
        
        return this.registry.items.register(new Item(new Properties()), id);
    }
    
    private final ItemStack createTabIcon () {
        
        return new ItemStack(this.tabIconItem);
    }
}