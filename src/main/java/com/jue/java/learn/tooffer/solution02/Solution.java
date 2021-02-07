package com.jue.java.learn.tooffer.solution02;

import com.jue.java.learn.tooffer.bean.TreeNode;

import java.util.ArrayList;

/**
 * @author JUE
 * @date 2019/6/18
 * @apiNote Solution
 * note: 0 error(s),0 warning(s)
 */
public class Solution {
    public static void main(String[] args) {
        //Solution solution = new Solution();
        //Solution2 solution = new Solution2();
        SolutionPerfect solution = new SolutionPerfect();
        System.out.println(solution.FindPath(new TreeNode("1,2,2,1,3,3,3,2,1,#,#,#,#,#,#,#,#,1,#,1"), 6));
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> child;
        int rootVal;
        //如果根节点的值本身就比加和值大,则没有结果
        if (null == root || (rootVal = root.val) > target) {
            return result;
        }
        ArrayList<Integer> road = new ArrayList<>();
        road.add(rootVal);
        //如果是叶子节点
        if (rootVal == target && null == root.left && null == root.right) {
            result.add(road);
            return result;
        } else {
            if (null != root.left) {
                child = FindPath(root.left, target - rootVal);
                result = path(result, child, road);
            }
            if (null != root.right) {
                child = FindPath(root.right, target - rootVal);
                result = path(result, child, road);
            }
        }
        return result;
    }

    private ArrayList<ArrayList<Integer>> path(ArrayList<ArrayList<Integer>> result,
                                               ArrayList<ArrayList<Integer>> child,
                                               ArrayList<Integer> road) {
        if (!child.isEmpty()) {
            for (ArrayList<Integer> row : child) {
                ArrayList<Integer> clone = (ArrayList<Integer>) road.clone();
                clone.addAll(row);
                //数组长度大的数组靠前
                int index = 0;
                for (; index < result.size(); index++) {
                    if (clone.size() > result.get(index).size()) {
                        break;
                    }
                }
                result.add(index, clone);
            }
        }
        return result;
    }
}

class Solution2 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> child;
        int rootVal;
        //如果根节点的值本身就比加和值大,则没有结果
        if (null == root || (rootVal = root.val) > target) {
            return result;
        }
        ArrayList<Integer> road = new ArrayList<>();
        road.add(rootVal);
        //如果是叶子节点
        if (rootVal == target && null == root.left && null == root.right) {
            result.add(road);
            return result;
        } else {
            if (null != root.left) {
                child = FindPath(root.left, target - rootVal);
                if (!child.isEmpty()) {
                    for (ArrayList<Integer> row : child) {
                        ArrayList<Integer> clone = (ArrayList<Integer>) road.clone();
                        clone.addAll(row);
                        result.add(clone);
                    }
                }
            }
            if (null != root.right) {
                child = FindPath(root.right, target - rootVal);
                if (!child.isEmpty()) {
                    for (ArrayList<Integer> row : child) {
                        ArrayList<Integer> clone = (ArrayList<Integer>) road.clone();
                        clone.addAll(row);
                        result.add(clone);
                    }
                }
            }
        }
        return result;
    }
}

class SolutionPerfect {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            //深度遍历->深度最深的为最前???没有实现....
            listAll.add(new ArrayList<Integer>(list));
        }
        list.remove(list.size() - 1);
        FindPath(root.left, target);
        FindPath(root.right, target);
        //找到叶子节点后回退方便下次寻找
        //System.out.println(list.get(list.size() - 1));
//        list.remove(list.size() - 1);
        return listAll;
    }
}
