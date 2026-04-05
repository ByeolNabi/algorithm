class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int k = 0; k < queries.length; k++){
            int i = queries[k][0];
            int j = queries[k][1];
            
            if(i==j) continue;
            
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
        return arr;
    }
}