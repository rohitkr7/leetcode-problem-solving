import java.util.Stack;
class Solution {
    
    
    
    public boolean isValid(String s) {
        
        HashMap<Character, Character> bracketPair = new HashMap<Character, Character>();
        bracketPair.put(')','(');
        bracketPair.put('}','{');
        bracketPair.put(']','[');
        
        Stack<Character> st = new Stack<Character>();
        char top ;
        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c=='[' ){
                st.push(c);
            }else{
                if(!st.isEmpty()){
                    top = st.peek();
                    if(top == bracketPair.get(c)){
                        st.pop();
                    }else{
                       return false; 
                    }
                }else{
                    return false;
                }
            }
        }
        
        return st.size() == 0;
    }
}