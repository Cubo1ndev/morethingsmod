package net.more.things.block.cutting_board;

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
public class CuttingBoardBlockEntityRenderer extends BlockEntityRenderer<CuttingBoardBlockEntity> {
   public CuttingBoardBlockEntityRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
      super(blockEntityRenderDispatcher);
   }

   @Override
   public void render(CuttingBoardBlockEntity cuttingBoardBlockEntity, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
      Direction direction = (Direction) cuttingBoardBlockEntity.getCachedState().get(CuttingBoardBlock.FACING);
      ItemStack itemStack = cuttingBoardBlockEntity.getItem();

      if (!itemStack.isEmpty()) {
         //System.out.println(itemStack);
         matrixStack.push();
         matrixStack.translate(0.5D, -0.225D, 0.5D);
         Direction direction2 = Direction.fromHorizontal(direction.getHorizontal() % 4);
         float g = direction2.asRotation();
         matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(g + 180.0F));
         matrixStack.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(90.0F));
         matrixStack.translate(0.0D, 0.0D, -0.31D);
         matrixStack.scale(0.6125F, 0.6125F, 0.6125F);
         MinecraftClient.getInstance().getItemRenderer().renderItem(itemStack, ModelTransformation.Mode.FIXED, i, j, matrixStack, vertexConsumerProvider);
         matrixStack.pop();
      }
   }
}
