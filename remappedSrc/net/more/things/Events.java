package net.more.things;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.more.things.crops.MoreThingsCrops;
import net.more.things.item.MoreThingsItems;

public class Events {
    public Events() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if ((entity instanceof SheepEntity) && ((player instanceof LivingEntity) ? ((LivingEntity) player).getMainHandStack() : ItemStack.EMPTY)
                    .getItem() == Items.BUCKET) {
                ItemStack itemStack = ((LivingEntity) player).getMainHandStack();
                player.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
                ItemUsage.method_30012(itemStack, player, new ItemStack(MoreThingsItems.SEMEN_BUCKET));
                if (!world.isClient) {
                    Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity) player, new ItemStack(MoreThingsItems.SEMEN_BUCKET));
                }
            }

            return ActionResult.PASS;
        });
        
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (new Identifier("minecraft", "blocks/grass").equals(id)) {
                FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
                builder.rolls(UniformLootTableRange.between(1, 1));
                builder.conditionally(RandomChanceLootCondition.builder(0.0625f));
                builder.withEntry(ItemEntry.builder(MoreThingsCrops.marihuana_plant.getSeed()).build());
                supplier.pool(builder);
            }
            /*} else if (new Identifier("minecraft", "entity/horse").equals(id)) {
                FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
                builder.rolls(UniformLootTableRange.between(1, 1));
                builder.conditionally(RandomChanceLootCondition.builder(0.0625f));
                builder.withEntry(ItemEntry.builder(MoreThingsItems.RAWHIDE_HORSE_ITEM).build());
                //builder.withFunction(LootFunction.apply(itemApplier, Consumer<ItemStack>, LootContext.Builder()))
                supplier.pool(builder);
            } else if (new Identifier("minecraft", "entity/llama").equals(id)) {
                FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
                builder.rolls(UniformLootTableRange.between(1, 1));
                builder.conditionally(RandomChanceLootCondition.builder(0.0625f));
                builder.withEntry(ItemEntry.builder(MoreThingsItems.RAWHIDE_LLAMA_ITEM).build());
                supplier.pool(builder);
            } else if (new Identifier("minecraft", "entity/mule").equals(id)) {
                FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
                builder.rolls(UniformLootTableRange.between(1, 1));
                builder.conditionally(RandomChanceLootCondition.builder(0.0625f));
                builder.withEntry(ItemEntry.builder(MoreThingsItems.RAWHIDE_MULE_ITEM).build());
                supplier.pool(builder);
            } else if (new Identifier("minecraft", "entity/pig").equals(id)) {
                FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
                builder.rolls(UniformLootTableRange.between(1, 1));
                builder.conditionally(RandomChanceLootCondition.builder(0.0625f));
                builder.withEntry(ItemEntry.builder(MoreThingsItems.RAWHIDE_PIG_ITEM).build());
                supplier.pool(builder);
            } else if (new Identifier("minecraft", "entity/polar_bear").equals(id)) {
                FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
                builder.rolls(UniformLootTableRange.between(1, 1));
                builder.conditionally(RandomChanceLootCondition.builder(0.0625f));
                builder.withEntry(ItemEntry.builder(MoreThingsItems.RAWHIDE_POLARBEAR_ITEM).build());
                supplier.pool(builder);
            } else if (new Identifier("minecraft", "entity/mooshroom").equals(id)) {
                FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
                builder.rolls(UniformLootTableRange.between(1, 1));
                builder.conditionally(RandomChanceLootCondition.builder(0.0625f));
                builder.withEntry(ItemEntry.builder(MoreThingsItems.RAWHIDE_MOOSHROOM_ITEM).build());
                supplier.pool(builder);
            } else if (new Identifier("minecraft", "entity/wolf").equals(id)) {
                FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
                builder.rolls(UniformLootTableRange.between(1, 1));
                builder.conditionally(RandomChanceLootCondition.builder(0.0625f));
                builder.withEntry(ItemEntry.builder(MoreThingsItems.RAWHIDE_WOLF_ITEM).build());
                supplier.pool(builder);
            } else if (new Identifier("minecraft", "entity/cow").equals(id)) {
                FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
                builder.rolls(UniformLootTableRange.between(1, 1));
                builder.conditionally(RandomChanceLootCondition.builder(0.0625f));
                builder.withEntry(ItemEntry.builder(MoreThingsItems.RAWHIDE_COW_ITEM).build());
                supplier.pool(builder);*/
        });
    }
}
