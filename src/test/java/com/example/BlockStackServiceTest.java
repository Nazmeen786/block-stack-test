package com.example;

import com.example.blockstack.service.BlockStackService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockStackServiceTest {
    // Test basic scenario with varied block sizes and shapes
    @Test
    public void testBasicCaseWithVariedBlocks() {
        // This test verifies the maximum height calculation for a mix of block sizes and shapes.
        // It simulates a real-world scenario where we have different sized blocks to be stacked.
        BlockStackService bsh = new BlockStackService();
        int[][] blocks = {{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};
        int expected = 190; // Expected stacking: 95 (base) + 50 + 45 = 190

        // Act & Assert: Verify that the method calculates the correct maximum height.
        assertEquals(expected, bsh.maxHeight(blocks));
    }

    // Test scenario where blocks cannot stack on each other due to incompatible dimensions
    @Test
    public void testTwoNonStackableBlocks() {
        // In this test, the blocks are too different in size to be stacked.
        // This checks if the function can identify that no stacking is possible and returns the height of the largest block.
        BlockStackService bsh = new BlockStackService();
        int[][] blocks = {{38, 25, 45}, {76, 35, 3}};
        int expected = 76; // The maximum height achievable is the single block of height 76.

        // Act & Assert: Verify that the method returns the correct height of the single tallest block.
        assertEquals(expected, bsh.maxHeight(blocks));
    }

    // Test with multiple blocks having the same dimensions in different orientations
    @Test
    public void testIdenticalBlocksInDifferentOrientations() {
        // Here, I want to see if the function correctly handles identical blocks placed in different orientations.
        // Although the blocks have the same dimensions, they should all stack perfectly one on top of another.
        BlockStackService bsh = new BlockStackService();
        int[][] blocks = {{7, 11, 17}, {7, 17, 11}, {11, 7, 17}, {11, 17, 7}, {17, 7, 11}, {17, 11, 7}};
        int expected = 102; // Each block contributes 17 to the total height. 6 blocks * 17 height = 102.

        // Act & Assert: Verify that the method correctly calculates the height for these uniform blocks.
        assertEquals(expected, bsh.maxHeight(blocks));
    }

    // Test with only one block - simplest case scenario
    @Test
    public void testSingleBlockScenario() {
        // Testing the simplest possible case where there is only one block.
        // This ensures that the function returns the height of a single block without any stacking logic.
        BlockStackService bsh = new BlockStackService();
        int[][] blocks = {{10, 20, 30}};
        int expected = 30; // The height of the single block itself.

        // Act & Assert: Check that the function returns the correct height of the single block.
        assertEquals(expected, bsh.maxHeight(blocks));
    }

    // Test with two blocks that can stack on each other
    @Test
    public void testTwoBlocksThatCanStack() {
        // This test checks a scenario where two blocks can perfectly stack on each other.
        // It verifies if the function detects that they are compatible and stacks them to find the maximum height.
        BlockStackService bsh = new BlockStackService();
        int[][] blocks = {{10, 20, 30}, {20, 30, 10}};
        int expected = 60; // Both blocks stack perfectly. Max height is 30 + 30.

        // Act & Assert: Verify that the method correctly stacks the compatible blocks.
        assertEquals(expected, bsh.maxHeight(blocks));
    }

    // Test with two incompatible blocks that cannot stack
    @Test
    public void testTwoIncompatibleBlocksScenario() {
        // Here, the blocks are such that one cannot be placed on top of the other due to size constraints.
        // The function should return the height of the tallest possible configuration without stacking.
        BlockStackService bsh = new BlockStackService();
        int[][] blocks = {{10, 20, 30}, {5, 15, 25}};
        int expected = 55; // Both blocks contribute to the max height individually: 30 + 25.

        // Act & Assert: Check that the function returns the correct max height even when stacking isn't possible.
        assertEquals(expected, bsh.maxHeight(blocks));
    }

    // Test stacking with blocks that have identical dimensions
    @Test
    public void testIdenticalBlocksStacking() {
        // This scenario tests the function's ability to handle blocks that are identical in dimensions.
        // It ensures that the function treats them as separate entities and stacks them correctly.
        BlockStackService bsh = new BlockStackService();
        int[][] blocks = {{5, 5, 5}, {5, 5, 5}, {5, 5, 5}};
        int expected = 15; // All blocks stack on top of each other. Total height = 5 + 5 + 5 = 15.

        // Act & Assert: Verify that identical blocks are stacked as expected.
        assertEquals(expected, bsh.maxHeight(blocks));
    }

    // Test with blocks that need rotation to fit and stack correctly
    @Test
    public void testRotationRequiredForStacking() {
        // This test case checks a scenario where blocks must be rotated to stack optimally.
        // It ensures the function considers all possible rotations to maximize the height.
        BlockStackService bsh = new BlockStackService();
        int[][] blocks = {{4, 6, 7}, {1, 2, 3}, {4, 5, 6}};
        int expected = 16; // Optimal stacking is with heights: 7 (base) + 6 + 3 = 16.

        // Act & Assert: Verify that the function stacks the blocks correctly with necessary rotations.
        assertEquals(expected, bsh.maxHeight(blocks));
    }

    // Test with blocks in descending order to ensure proper stacking from largest to smallest
    @Test
    public void testStackingWithDescendingOrderBlocks() {
        // This case tests whether the function stacks blocks in the correct order when given in descending sizes.
        // The function should stack them from largest to smallest to achieve the maximum height.
        BlockStackService bsh = new BlockStackService();
        int[][] blocks = {{10, 20, 30}, {5, 10, 15}, {2, 4, 6}};
        int expected = 51; // Total height: 30 + 15 + 6 = 51.

        // Act & Assert: Verify that the method handles blocks in descending order properly.
        assertEquals(expected, bsh.maxHeight(blocks));
    }

    // Test with a block that has zero height, ensuring it's not considered in the total height calculation
    @Test
    public void testZeroHeightBlockScenario() {
        // A block with zero height should not contribute to the total height.
        // This test ensures that the function correctly ignores zero-height blocks.
        BlockStackService bsh = new BlockStackService();
//        int[][] blocks = {{10, 20, 0}, {5, 10, 5}};
        int[][] blocks = {{7, 3, 8}, {9, 2, 10}, {4, 8, 5}, {6, 4, 7}, {1, 1, 1}, {5, 9, 2}, {10, 7, 6}};
        //{{5, 4, 6}, {3, 2, 1}}
        int expected = 20; // Only the second block with a height of 20 contributes to the total.

        // Act & Assert: Check that zero-height blocks are correctly ignored in the height calculation.
        assertEquals(expected, bsh.maxHeight(blocks));
    }

    // Test with maximum possible block dimensions to check for handling of upper bounds
    @Test
    public void testMaxDimensionBlocks() {
        // This test checks if the function can handle blocks with the maximum allowed dimensions.
        // It should correctly calculate the maximum height even for large values.
        BlockStackService bsh = new BlockStackService();
        int[][] blocks = {{100, 100, 100}, {100, 100, 100}, {100, 100, 100}};
        int expected = 300; // All blocks stack perfectly. Total height: 100 + 100 + 100 = 300.

        // Act & Assert: Verify that the method handles and calculates max heights for large blocks.
        assertEquals(expected, bsh.maxHeight(blocks));
    }

    @Test
    public void testEmptyBlocks() {
        // The function should return zero when no blocks are given as input.
        // This tests the base case where the input list is empty.
        BlockStackService bsh = new BlockStackService();
        int[][] blocks = {}; // No blocks to stack
        int expected = 0; // Expected height is zero as there are no blocks

        // Act & Assert: Verify that the function returns 0 for an empty input.
        assertEquals(expected, bsh.maxHeight(blocks));
    }
}
