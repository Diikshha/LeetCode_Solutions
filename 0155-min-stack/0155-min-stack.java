class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int values) {
        long value=values;
        if(st.isEmpty()){
            min=value;
            st.push(value);
        }
        else{
            if(value>=min){
                st.push(value);
            }
            else{
                st.push(2*value-min);
                min=value;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        long n = st.peek();
        st.pop();
        if(n<min){
            min=2*min-n;
        }
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        long n=st.peek();
        if(min<=n){
            return (int)n;
        }
        return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */