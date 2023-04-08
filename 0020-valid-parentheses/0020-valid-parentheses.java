class Solution {
    
    public boolean validate(Stack<Character> s, Character ch) {
        boolean ans = true;
        if(s.isEmpty()) {
            return false;
        }
        switch(s.pop()) {
            case '[':
                ans = ch == ']' ? true : false;
                break;
            case '(':
                ans = ch == ')' ? true : false;
                break;
            case '{':
                ans = ch == '}' ? true : false;
                break;
        }
        return ans;
    }
    
    public boolean isValid(String s) {
        int n = s.length();
        
       
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0;  i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(ch == ']' || ch == '}' || ch == ')') {
                if(!validate(stack, ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
            
        }
        
        if(!stack.isEmpty()) {
            return false;
        }
        
       return true; 
    }
}