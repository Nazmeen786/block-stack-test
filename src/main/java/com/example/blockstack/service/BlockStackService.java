package com.example.blockstack.service;

import org.springframework.stereotype.Service;

import java.util.*;
@Service
    public class BlockStackService {

    public int maxHeight(int[][] blocks) {
        // Edge case: No blocks available
        if (blocks == null || blocks.length == 0) {
            return 0; // No blocks to stack, so height is zero
        }

        // Step 1: Normalize the blocks by rotating each to ensure dimensions are ordered
        normalizeBlocks(blocks);

        // Step 2: Sort blocks based on their dimensions (length, width, height)
        // This will help in the DP step to easily check if one block can be placed on another
        Arrays.sort(blocks, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // Primary sort by length
            if (a[1] != b[1]) return a[1] - b[1]; // Secondary sort by width
            return a[2] - b[2]; // Tertiary sort by height
        });

        int n = blocks.length;
        int[] dp = new int[n]; // dp[i] represents the max height ending with block i

        // Step 3: Initialize the dp array with the height of each block
        for (int i = 0; i < n; ++i) {
            dp[i] = blocks[i][2]; // Initial height is just the height of the block itself
        }

        // Step 4: Dynamic programming to compute maximum stack height
        // Iterate through each block and determine the maximum stack height ending with that block
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                // Check if block j can be placed below block i
                if (canStack(blocks[j], blocks[i])) {
                    // Update the maximum height at block i by adding block i's height to dp[j]
                    dp[i] = Math.max(dp[i], dp[j] + blocks[i][2]);
                }
            }
        }

        // Step 5: Find and return the maximum value from the dp array
        return Arrays.stream(dp).max().orElse(0);
    }

    /**
     * Normalizes each block such that its dimensions are sorted in ascending order.
     * This ensures that we always treat the smallest dimension as length, the next as width,
     * and the largest as height, facilitating easier comparisons.
     *
     * @param blocks 2D Array where each block is represented by [width, length, height].
     */
    private void normalizeBlocks(int[][] blocks) {
        for (int[] block : blocks) {
            Arrays.sort(block); // Sort dimensions so length <= width <= height
        }
    }

    /**
     * Determines if the first block can be placed on top of the second block.
     *
     * @param lower The lower block in the stack.
     * @param upper The block to be placed on top of the lower block.
     * @return True if the upper block can be placed on the lower block, false otherwise.
     */
    private boolean canStack(int[] lower, int[] upper) {
        // Each dimension of the upper block must be less than or equal to the corresponding dimension of the lower block
        return lower[0] <= upper[0] && lower[1] <= upper[1] && lower[2] <= upper[2];
    }
}
