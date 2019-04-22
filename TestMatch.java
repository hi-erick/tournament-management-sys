public class TestMatch
{
   public static void main(String[] args)
   {
      String[] b = new String[10];
      for(int i=0;i<=9;i++)
         b[i] =  Integer.toString(i+1);
      try
      {
         Matchups1 matchup = new Matchups1(b);
      }
      catch(Exception e)
      {
         System.out.println("You dumbass, Message :" + e);
      }
      System.out.println("done");
   }
}