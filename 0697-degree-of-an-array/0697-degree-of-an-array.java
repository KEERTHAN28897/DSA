class Node {
    int first;
    int second;
    int count;
    
    Node(int first, int second, int count) {
        this.first = first;
        this.second = second;
        this.count = count;
    }
}

class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        Map<Integer, Node> nodes = new HashMap<>();
        Map<Integer, Integer> numToCount = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int count = numToCount.getOrDefault(nums[i], 0);
            if(count == 0) {
                nodes.put(nums[i], new Node(i, i, 1));
            } else {
                Node node = nodes.get(nums[i]);
                node.second = i;
                node.count += 1;
            }
            count += 1;
            numToCount.put(nums[i], count);
            if(max < count) {
                max = count;
            }
        }
        int min = nums.length + 1;
        for(Map.Entry<Integer, Node> element : nodes.entrySet()) {
            Node node = element.getValue();
            if(node.count == max) {
                int diff = (node.second - node.first) + 1;
                if(min > diff) {
                    min = diff;
                }
            }
        }
        return min;
    }
}