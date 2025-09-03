class Solution {
    int single(int[] arr) {

        int xor = 0;
        for (int i : arr) {
            xor = xor ^ i;
        }
        return xor;
    }
}