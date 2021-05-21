package net.more.things.block.piggy_bank;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PiggyBankBlock extends BlockWithEntity {
    public static final DirectionProperty FACING;
    
    public PiggyBankBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }
    
    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
       return new PiggyBankBlockEntity();
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

	@Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
       switch((Direction)state.get(FACING)) {
       case NORTH:
          return VoxelShapes.cuboid(0.175D, 0D, 0.175D, .825D, 0.75D, 1D);
       case SOUTH:
          return VoxelShapes.cuboid(0.175D, 0D, 0D, .825D, 0.75D, 0.825D);
       case EAST:
          return VoxelShapes.cuboid(0D, 0D, 0.175D, .825D, 0.75D, 0.825D);
       case WEST:
          return VoxelShapes.cuboid(0.175D, 0D, 0.175D, 1D, 0.75D, 0.825D);
       default:
          return VoxelShapes.cuboid(0.175D, 0D, 0.175D, .825D, 0.75D, 1D);
       }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }
    
    public BlockState getPlacementState(ItemPlacementContext context) {
		return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getPlayerFacing().getOpposite());
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
    }
}