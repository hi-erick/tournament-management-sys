
public class Teams 
{
   private String[] a;
   private int nElems = 0;
   private String names;
   public Teams() 
   {
      a = new String[10];
   }
   public void insert(String value)
   {
      a[nElems] = value;
      nElems++;
   }
  //show team names
   public String display() 
   {
      names = a[0];
      if(a[1]==null)
      {
         return names;
      }else
      {
      for(int i = 1; i<nElems; i++)
      {
         names = (names + " " + a[i]);
      }
      return names;
      }  
   }
}