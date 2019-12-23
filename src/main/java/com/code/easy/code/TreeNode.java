package com.code.easy.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
}
