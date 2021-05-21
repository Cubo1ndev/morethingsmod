package net.more.things.block.drying_rack;

import java.util.Optional;

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
import net.more.things.recipes.drying_rack.DryingRackRecipe;

public class DryingRackBlock extends BlockWithEntity {
   public static final DirectionProperty FACING;

   public DryingRackBlock(Settings settings) {
      super(settings);
      this.setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
   }

   @Override
   public BlockEntity createBlockEntity(BlockView blockView) {
      return new DryingRackBlockEntity();
   }

   public BlockRenderType getRenderType(BlockState state) {
      return BlockRenderType.MODEL;
   }

   @Override
   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      switch ((Direction) state.get(FACING)) {
         case NORTH:
            return VoxelShapes.cuboid(0D, 0.75D, 0.75D, 1D, 1D, 1D);
         case SOUTH:
            return VoxelShapes.cuboid(0D, 0.75D, 0D, 1D, 1D, 0.25D);
         case EAST:
            return VoxelShapes.cuboid(0D, 0.75D, 0D, .25D, 1D, 1D);
         case WEST:
            return VoxelShapes.cuboid(0.75D, 0.75D, 0D, 1D, 1D, 1D);
         default:
            return VoxelShapes.cuboid(0D, 0.75D, 0D, 1D, 1D, 0.25D);
      }
   }

   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(Properties.HORIZONTAL_FACING);
   }

   public BlockState getPlacementState(ItemPlacementContext context) {
      return (BlockState) this.getDefaultState().with(Properties.HORIZONTAL_FACING,
            context.getPlayerFacing().getOpposite());
   }

   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
         BlockHitResult hit) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof DryingRackBlockEntity) {
         DryingRackBlockEntity dryingRackBlockEntity = (DryingRackBlockEntity) blockEntity;
         if (dryingRackBlockEntity.getItem().isEmpty()) {
            ItemStack itemStack = player.getStackInHand(hand);
            Optional<DryingRackRecipe> optional = dryingRackBlockEntity.getRecipeFor(itemStack);
            if (optional.isPresent()) {
               ItemStack itemm = itemStack.copy();
               itemm.setCount(1);
               if (!world.isClient && dryingRackBlockEntity.addItem(itemm, ((DryingRackRecipe) optional.get()).getTime())) {
                  player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
                  return ActionResult.SUCCESS;
               }

               return ActionResult.CONSUME;
            } 
         } else {
            if (!world.isClient) {
               ItemStack item = dryingRackBlockEntity.getItem();
               ItemScatterer.spawn(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), item);
               dryingRackBlockEntity.sync();
            }
         }
      }

      return ActionResult.PASS;
   }

   static {
      FACING = HorizontalFacingBlock.FACING;
   }
}