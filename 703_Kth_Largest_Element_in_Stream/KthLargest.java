class KthLargest {
    int k;
    int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        quicksort(0, nums.length-1);
    }
    
    public int add(int val) {
        int[] newNums = new int[nums.length + 1];
        int currentIndex = 0;
        boolean added = false;
    
        for (int i = 0; i < nums.length; i++) {
            if (!added && val >= nums[i]) {
                newNums[currentIndex] = val;
                added = true;
                i--;
            } else newNums[currentIndex] = nums[i];
            currentIndex++;
        }
    
        if (!added) {
            newNums[currentIndex] = val;
        }
    
        nums = newNums;
        
        return nums[k - 1];
    }
    

    private int partition(int p, int r) {
        int x = nums[r];
        int i = p-1;
        for(int j = p; j < r; j++) {
            if (nums[j] >= x) {
                i = i + 1;
                int aux = nums[i];
                nums[i] = nums[j]; 
                nums[j] = aux;
            }
        }
        i = i + 1;
        nums[r] = nums[i]; 
        nums[i] = x;
        return i;
    }

    private void quicksort (int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            quicksort(p, q-1);
            quicksort(q+1, r);
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */