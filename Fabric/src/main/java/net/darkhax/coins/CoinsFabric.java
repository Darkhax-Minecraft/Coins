package net.darkhax.coins;

import net.fabricmc.api.ModInitializer;

public class CoinsFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        CoinsContent.init();
    }
}