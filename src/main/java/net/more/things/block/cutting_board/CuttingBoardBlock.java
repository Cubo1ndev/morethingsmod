package net.more.things.block.cutting_board;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CuttingBoardBlock extends BlockWithEntity {
   public static final DirectionProperty FACING;

   public CuttingBoardBlock(Settings settings) {
      super(settings);
      this.setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
   }

   @Override
   public BlockEntity createBlockEntity(BlockView blockView) {
      return new CuttingBoardBlockEntity();
   }

   public BlockRenderType getRenderType(BlockState state) {
      return BlockRenderType.MODEL;
   }

   @Override
   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      return VoxelShapes.cuboid(0.05D, 0D, 0.15D, 0.95D, 0.075D, 0.85D);
   }

   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(Properties.HORIZONTAL_FACING);
   }

   public BlockState getPlacementState(ItemPlacementContext context) {
      return (BlockState) this.getDefaultState().with(Properties.HORIZONTAL_FACING,
            context.getPlayerFacing().getOpposite());
   }

   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof CuttingBoardBlockEntity) {
         CuttingBoardBlockEntity cuttingBoardBlockEntity = (CuttingBoardBlockEntity) blockEntity;
         if (cuttingBoardBlockEntity.getItem().isEmpty()) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (!itemStack.isEmpty()) {
               ItemStack itemm = itemStack.copy();
               itemm.setCount(1);
               if (!world.isClient && cuttingBoardBlockEntity.addItem(itemm)) {
                  player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
                  return ActionResult.SUCCESS;
               }

               return ActionResult.CONSUME;
            } 
         } else {
            if (!world.isClient) {
               ItemStack item = cuttingBoardBlockEntity.getItem();
               ItemScatterer.spawn(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), item);
               cuttingBoardBlockEntity.sync();
            }
         }
      }

      return ActionResult.PASS;
   }

   static {
      FACING = HorizontalFacingBlock.FACING;
   }
}