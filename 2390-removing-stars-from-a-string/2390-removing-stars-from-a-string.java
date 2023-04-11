class Solution {
    public String removeStars(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack();
        List<Integer> del = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            char ch = sb.charAt(i);
            if(ch == '*') {
                if(stack.isEmpty()) {
                    ch = '-';
                } else {
                    int pos = stack.pop();
                    sb.setCharAt(pos, '-');
                    del.add(pos);
                }
                sb.setCharAt(i, '-');
                del.add(i);
 
            } else {
                stack.add(i);
            }
        }
        
        String ans = sb.toString();
        String out = ans.replace("-", "");
        

        System.out.println(out);
        return out;
    }
}