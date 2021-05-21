package net.more.things.block.drying_rack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;

@Environment(EnvType.CLIENT)
public class DryingRackBlockEntityRenderer extends BlockEntityRenderer<DryingRackBlockEntity> {
   public DryingRackBlockEntityRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
      super(blockEntityRenderDispatcher);
   }

   @Override
   public void render(DryingRackBlockEntity dryingRackBlockEntity, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
      Direction direction = (Direction) dryingRackBlockEntity.getCachedState().get(DryingRackBlock.FACING);
      ItemStack itemStack = dryingRackBlockEntity.getItem();

      if (!itemStack.isEmpty()) {
         System.out.println(itemStack);
         matrixStack.push();
         matrixStack.translate(0.5D, 0.4D, 0.125D);
         Direction direction2 = Direction.fromHorizontal(direction.getHorizontal() % 4);
         float g = direction2.asRotation();
         matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(g));
         matrixStack.translate(0.0D, 0.0D, 0.0D);
         matrixStack.scale(0.8F, 0.8F, 0.8F);
         MinecraftClient.getInstance().getItemRenderer().renderItem(itemStack, ModelTransformation.Mode.FIXED, i, j, matrixStack, vertexConsumerProvider);
         matrixStack.pop();
      }
   }
}
