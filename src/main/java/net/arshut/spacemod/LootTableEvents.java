package net.arshut.spacemod;

import net.arshut.spacemod.items.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = SpaceMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LootTableEvents {

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation name = event.getName();

        if (name.getNamespace().equals("minecraft") && (
                name.getPath().equals("blocks/ice")
                        || name.getPath().equals("blocks/packed_ice")
                        || name.getPath().equals("blocks/blue_ice")
                        || name.getPath().equals("blocks/frosted_ice"))) {

            LootTable table = event.getTable();

            // Remove 'blocks/' to get the item registry name
            String blockName = name.getPath().replace("blocks/", "");
            ResourceLocation itemLocation = new ResourceLocation(name.getNamespace(), blockName);

            LootPool pool = LootPool.lootPool()
                    .add(LootItem.lootTableItem(ForgeRegistries.ITEMS.getValue(itemLocation)))
                    .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                            .of(ModItems.ICE_AXE.get())))
                    .build();

            table.addPool(pool);
        }
    }
}