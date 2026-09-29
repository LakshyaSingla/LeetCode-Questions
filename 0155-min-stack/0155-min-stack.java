
class MinStack {
    private Deque<Long> st;
    private long min;

    public MinStack() {
        st = new ArrayDeque<>();
    }
    
    public void push(int value) {
        long val = value;
        if (st.isEmpty()) {
            min = val;
            st.push(val);
            return;
        }

        if (val >= min) {
            st.push(val);
        } else {
            st.push(2 * val - min);
            min = val;
        }
    }
    
    public void pop() {
        if (st.isEmpty()) return;

        long x = st.pop();
        if (x < min) {
            min = 2 * min - x;
        }
    }
    
    public int top() {
        long x = st.peek();
        if (x < min) {
            return (int) min;
        }
        return (int) x;
    }
    
    public int getMin() {
        return (int) min;
    }
}