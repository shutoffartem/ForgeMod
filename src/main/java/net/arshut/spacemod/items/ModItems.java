package net.arshut.spacemod.items;

import net.arshut.spacemod.SpaceMod;
import net.arshut.spacemod.items.tools.IceAxe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SpaceMod.MOD_ID);

    public static final RegistryObject<Item> ICE_AXE = ITEMS.register("iceaxe",
            () -> new IceAxe(Tiers.STONE, 1, -2.8F, new Item.Properties().durability(400)));
    public static final RegistryObject<Item> HE3_BUCKET = ITEMS.register("he3bucket",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static void Register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
