import java.util.*; 
public class Main
{
	public static void main(String[] args) {
		String infix = "A + ( B * C )"; 
		String postfix = infixToPostfix(infix);
		String prefix = infixToPrefix(infix);
		
		System.out.println("Infix of postfix : " + PostfixToPrefix(postfix));
	}
	
	public static String PrefixToPostfix(String prefix) {
	    Stack<String> st = new Stack(); 
	    StringBuilder infix = new StringBuilder(); 
	    
	    for (int i = prefix.length() - 1; i >= 0; i--) {
	        char ch = prefix.charAt(i);
	        
	        if (isOperand(ch)) st.push(ch + "");
	        else if (isOperator(ch)) {
	            StringBuilder temp = new StringBuilder(); 
	            String op1 = st.pop(); 
	            String op2 = st.pop(); 
	            temp.append(op1); 
	            temp.append(op2);
	            temp.append(ch);
	            
	            st.push(temp.toString());
	        }
	    }
	    
	    return st.pop(); 
	}
	
	public static String PostfixToPrefix(String postfix) {
	    Stack<String> st = new Stack(); 
	    StringBuilder infix = new StringBuilder(); 
	    
	    for (int i = 0; i < postfix.length(); i++) {
	        char ch = postfix.charAt(i);
	        
	        if (isOperand(ch)) st.push(ch + "");
	        else if (isOperator(ch)) {
	            StringBuilder temp = new StringBuilder(); 
	            String op1 = st.pop(); 
	            String op2 = st.pop(); 
	            temp.append(ch);
	            temp.append(op2);
	            temp.append(op1);
	            
	            st.push(temp.toString());
	        }
	    }
	    
	    return st.pop(); 
	}
	
	public static String PrefixToInfix(String prefix) {
	    Stack<String> st = new Stack(); 
	    StringBuilder infix = new StringBuilder(); 
	    
	    for (int i = prefix.length() - 1; i >= 0; i--) {
	        char ch = prefix.charAt(i);
	        
	        if (isOperand(ch)) st.push(ch + "");
	        else if (isOperator(ch)) {
	            StringBuilder temp = new StringBuilder(); 
	            temp.append("(");
	            String op1 = st.pop(); 
	            String op2 = st.pop(); 
	            temp.append(op1); 
	            temp.append(ch);
	            temp.append(op2);
	            temp.append(")");
	            
	            st.push(temp.toString());
	        }
	    }
	    
	    return st.pop(); 
	}
	
	public static String PostfixToInfix(String postfix) {
	    Stack<String> st = new Stack(); 
	    StringBuilder infix = new StringBuilder(); 
	    
	    for (int i = 0; i < postfix.length(); i++) {
	        char ch = postfix.charAt(i);
	        
	        if (isOperand(ch)) st.push(ch + "");
	        else if (isOperator(ch)) {
	            StringBuilder temp = new StringBuilder(); 
	            temp.append("(");
	            String op1 = st.pop(); 
	            String op2 = st.pop(); 
	            temp.append(op2); 
	            temp.append(ch);
	            temp.append(op1);
	            temp.append(")");
	            
	            st.push(temp.toString());
	        }
	    }
	    
	    return st.pop(); 
	}
	
	public static String infixToPrefix(String infix) {
	    String reversedString = reverseString(infix);
	    String postfix = infixToPostfix(reversedString);
	    String prefix = reverseString(postfix);
	   
	    return prefix; 
	}
	
	public static String reverseString(String infix) {
	    int i = 0; 
	    int j = infix.length() - 1; 
	    char[] ch = infix.toCharArray(); 
	    
	    while (i < j) {
	        char temp = ch[i]; 
	        ch[i] = ch[j];
	        ch[j] = temp;
	        i++; j--; 
	    }
	    
	    for (i = 0; i < ch.length; i++) {
	        if (ch[i] == '(') ch[i] = ')';
	        else if (ch[i] == ')') ch[i] = '(';
	    }
	    
	    return new String(ch);
	}
	
	public static String infixToPostfix(String infix) {
	    Stack<Character> st = new Stack<>();
	    StringBuilder postfix = new StringBuilder(); 
	    
	    for (int i = 0;i < infix.length(); i++) {
	        char ch = infix.charAt(i);
	        
	        if (isOperand(ch)) postfix.append(ch);
	        else if (ch == '(') st.push(ch);
	        else if (ch == ')') {
	            while (!st.empty() && st.peek() != '(') {
	                postfix.append(st.peek());
	                st.pop(); 
	            }
	            if (!st.empty() && st.peek() == '(') st.pop(); 
	        }
	        else if (isOperator(ch)) {
	            while (!st.empty() && 
	                (precendence(st.peek()) > precendence(ch) || 
	                (precendence(st.peek()) == precendence(ch) && ch != '^'))) {
    	                postfix.append(st.peek()); 
    	                st.pop(); 
	            }
	            st.push(ch);
	        }
	    }
	    
	    while (!st.empty()) {
	        postfix.append(st.peek()); 
	        st.pop(); 
	    }
	    
	    return postfix.toString(); 
	}
	
	public static boolean isOperand(char c) {
	    return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
	}
	
	public static boolean isOperator(char c) {
	    return c == '*' || c == '/' || c == '+' || c == '-' || c == '^';
	}
	
	public static int precendence(char c) {
	    if (c == '^') return 3; 
	    else if (c == '*' || c == '/') return 2; 
	    else if (c == '+' || c == '-') return 1; 
	    
	    return -1; 
	}
}