package net.darkhax.coins;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.darkhax.bookshelf.item.ItemGroupBase;
import net.darkhax.bookshelf.registry.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootTables;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("coins")
public class Coins {
    
    private final Logger log = LogManager.getLogger("Coins");
    private final RegistryHelper registry = new RegistryHelper("coins", this.log, new ItemGroupBase("coins", this::createTabIcon));
    
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

        /*
        this.registry.injectTable(LootTables.CHESTS_PILLAGER_OUTPOST);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_ARMORER);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_BUTCHER);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_CARTOGRAPHER);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_DESERT_HOUSE);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_FISHER);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_FLETCHER);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_MASON);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_PLAINS_HOUSE);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_SAVANNA_HOUSE);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_SHEPHERD);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_SHEPHERD);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_SNOWY_HOUSE);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_TAIGA_HOUSE);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_TANNERY);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_TEMPLE);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_TOOLSMITH);
        this.registry.injectTable(LootTables.CHESTS_VILLAGE_VILLAGE_WEAPONSMITH);
         */

        this.registry.initialize(FMLJavaModLoadingContext.get().getModEventBus());
    }
    
    private Item createSimpleItem (String id) {
        
        return this.registry.registerItem(new Item(new Properties()), id);
    }
    
    private final ItemStack createTabIcon () {
        
        return new ItemStack(this.tabIconItem);
    }
}