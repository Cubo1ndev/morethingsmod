package net.more.things.crops;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class CropBoundingBoxFactory {

    public CropBoundingBoxFactory() { };

    public static VoxelShape[] buildBoundingBoxes(Double weight, Double positionxz, float[] heights) {
        VoxelShape[] boxes = new VoxelShape[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            boxes[i] = Block.createCuboidShape(positionxz, 0.0D, positionxz, weight, heights[i], weight);
        }
        return boxes;
    }
}
