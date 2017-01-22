//-----------------------------------------------------------------------------
// Stack.java
// An integer stack ADT
//-----------------------------------------------------------------------------

class Stack{

   private class Node{
      
      // Fields
      private int data;
      private Node next;
      
      // Constructor
      Node(int data) { 
         this.data = data; 
         this.next = null; 
      }

      // toString()
      // Overrides Object's toString() method.
      public String toString() { 
         return String.valueOf(data); 
      }

      // equals()
      // Overrides Object's equals() method.
      public boolean equals(Object x){
         boolean eq = false;
         Node that;

         if(x instanceof Node){
            that = (Node)x;
            eq = (this.data==that.data);
         }
         return eq;
      }
   }

   // Fields
   private Node top;
   private int height;

   // Constructor
   Stack() { 
      top = null; 
      height = 0; 
   }


   // Access Functions --------------------------------------------------------

   // isEmpty()
   // Returns true if Stack is empty, false otherwise.
   boolean isEmpty() { 
      return height == 0; 
   }

   // getHeight()
   // Returns height of Stack.
   int getHeight() { 
      return height; 
   }

   // getTop()
   // Returns top element.
   // Pre: !this.isEmpty()
   int getTop(){
      if( this.isEmpty() ){
         throw new RuntimeException(
            "Stack Error: getTop() called  on empty Stack");
      }
      return top.data;
   }


   // Manipulation Procedures -------------------------------------------------

   // push()
   // Places data on top of Stack.
   void push(int data){
      Node N = new Node(data);
      if( isEmpty() ){
         top = N;
      }else{
         N.next = top;
         top = N;
      }
      height++;
   }

   // pop()
   // Deletes top element.
   // Pre: !this.isEmpty()
   void pop(){
      if(this.isEmpty()){
         throw new RuntimeException(
            "Stack Error: pop() called on empty Stack");
      }
      top = top.next;
      height--;
   }


   // Other Functions ---------------------------------------------------------

   // toString()
   // Overrides Object's toString() method.
   public String toString(){
      StringBuffer sb = new StringBuffer();
      Node N = top;
      while( N!=null ){
         sb.append(" ");
         sb.append(N.toString());
         N = N.next;
      }
      return new String(sb);
   }

   // equals()
   // Overrides Object's equals() method.  Returns true if x is a Stack storing
   // the same integer sequence as this Stack.
   public boolean equals(Object x){
      boolean eq = false;
      Stack S;
      Node N, M;

      if(x instanceof Stack){
         S = (Stack)x;
         eq = (this.height==S.height);
         N = this.top;
         M = S.top;
         while( eq && N!=null ){
            eq = N.equals(M);
            N = N.next;
            M = M.next;
         }
      }
      return eq;
   }

   // copy()
   // Returns a new Stack identical to this Stack.
   Stack copy(){
      Stack S = new Stack();
      Node N, M;

      if( !this.isEmpty() ){
         N = this.top;
         M = new Node(N.data);
         S.top = M;
         S.height++;
         N = N.next;
         while( N!=null ){
            M.next = new Node(N.data);
            M = M.next;
            S.height++;
            N = N.next;
         }
      }
      return S;
   }

}
