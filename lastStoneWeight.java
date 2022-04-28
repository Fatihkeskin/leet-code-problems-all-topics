class Solution {

    public int lastStoneWeight(int[] stones) {
        List<Integer> stonesList = Arrays.stream(stones).boxed().collect(Collectors.toList());

        while (stonesList.size() > 1) {
            smashStones(stonesList);
        }
        
        if (stonesList.size() ==0)
            return 0;
        return stonesList.get(0);
    }

    private void smashStones(List<Integer> stones) {
        int first = findBiggest(stones);
        int second = findBiggest(stones);
        if(first > second) {
            stones.add(first-second);
        }
    }

    private int findBiggest(List<Integer> stones) {
        int biggest = -1;
        int index = -1;
        for (int i = 0; i < stones.size(); i++) {
            if (stones.get(i) > biggest) {
                biggest = stones.get(i);
                index = i;
            }
        }
        stones.remove(index);
        return biggest;
    }
}