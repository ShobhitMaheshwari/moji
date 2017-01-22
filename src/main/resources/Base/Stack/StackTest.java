//-----------------------------------------------------------------------------
// StackTest.java
// A test client for the Stack ADT
//-----------------------------------------------------------------------------

class StackTest{
   public static void main(String[] args){
      Stack A = new Stack();
      Stack B = new Stack();
      Stack C = null;

      for(int i=1; i<=10; i++){
         A.push(i);
         B.push(11-i);
      }
      System.out.println("A = " + A);
      System.out.println("B = " + B);
      for(int i=1; i<=6; i++){
         A.push(B.getTop());
         B.pop();
      }
      System.out.println("A = " + A);
      System.out.println("B = " + B);
      C = A.copy();
      System.out.println("C = " + C);
      System.out.println("A " + (A.equals(B)?"equals":"does not equal") + " B");
      System.out.println("A " + (A.equals(C)?"equals":"does not equal") + " C");
   }
}
