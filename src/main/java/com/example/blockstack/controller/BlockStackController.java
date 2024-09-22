package com.example.blockstack.controller;

import com.example.blockstack.service.BlockStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/blocks")
    public class BlockStackController {

        @Autowired
        private BlockStackService blockstackService;

        @PostMapping("/max-height")
        public int getMaxHeight(@RequestBody int[][] blocks) {
            return blockstackService.maxHeight(blocks);
        }
    }

