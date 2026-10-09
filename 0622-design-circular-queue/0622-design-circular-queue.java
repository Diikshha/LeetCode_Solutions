class MyCircularQueue {
    int[] arr;
    int f;
    int r=0;
    int size;
    public MyCircularQueue(int k) {
        arr=new int[k];
        
    }
    public boolean enQueue(int value) {
        if(size==arr.length) return false;
        arr[r++]=value;
        if(r==arr.length) r=0;
        size++;
        return true; 
    }
    public boolean deQueue() {
        if(size==0) return false;
        f++;
        if(f==arr.length) f=0;
        size--;
        return true; 
    }
    public int Front() {
        if(size==0) return -1;
        int ans=arr[f];
        return ans; 
    }
    public int Rear() {
        if(size==0) return -1;
        int index=r-1;
        if(index<0) index=arr.length-1;
        int ans=arr[index];
        return ans; 
    }
    public boolean isEmpty() {
        if(size==0) return true;
        else return false;
        
    }
    public boolean isFull() {
        if(size==arr.length) return true;
        else return false; 
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */