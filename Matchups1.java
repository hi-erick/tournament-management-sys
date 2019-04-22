import java.util.Random;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
public class Matchups1
{
   private String[] a;
   private int nElems = 0;
   int mUps;
   public Matchups1(String[] arr)throws IOException
   {
      nElems = count(arr);
      mUps = compLength(nElems);
      schedule(nElems,arr, mUps);
   }
   public static int count(String[] arr)
   {
      int j = 0;
      String[] a=arr;
      for(int i=0;i<=10;i++)
      {
         try
         {
            if(arr[i]!=null)
               j++;
         }
         catch(Exception e)
         {
            break;
         }
      }
      return (j);
   }
   public void schedule(int nElems, String[] arr, int mUps)throws IOException
   {
      int i=0;
      int m=0;
      boolean isFound = false;
      Path file = Paths.get("C:\\Users\\saulp\\Desktop\\spring 2019\\schedule.txt");
      String str = "";
      String checkStr = "";
      String[] track = new String[mUps];
      int instance=0;
      int check = 0;
      for(int n=0;n<=mUps-1;n++)
         {
            track[n]="";
         }
      int int1 = 0;
      int int2 = (int1+1)%(nElems);
      do
      {
         if(int1==int2)
         {
            int2=(int2+1)%nElems;
         }
         checkStr = int1+" vs "+int2;
         if(m>0)
         {
            for(i=0;i<=mUps-1;i++)
            {
               if(track[i].equals(checkStr)==true)
               {
                  isFound=true;
                  break;
               }
            }
         i=0;
         }
         if(isFound==false)
         {
            instance = matchCount(int1, int2, file,arr);
            System.out.println("Instance: " + instance);
            if(instance>=2)
            {
               isFound=true;
            }
            instance = 0;
         }
         if(isFound==false)
         {
            track[i]=checkStr;
            str = str + arr[int1]+" vs "+arr[int2]+"\n";
            m++;
            int1=(int1+1)%nElems;
            check=0;
         }
         if(check>=4)
         {
            int1=(int1+1)%nElems;
            check=0;
         }
         int2=(int2+1)%nElems;
         check++;
         isFound=false;
      }while(m<mUps);
      byte[] data = str.getBytes();
      OutputStream output = null;
      try
      {
         output = new 
            BufferedOutputStream(Files.newOutputStream(file, APPEND));
         output.write(data);
         output.flush();
         output.close();
      }
      catch(Exception e)
      {
         try
         {
            output = new 
               BufferedOutputStream(Files.newOutputStream(file, CREATE));
            output.write(data);
            output.flush();
            output.close();
         }
         catch(Exception b)
         {
            System.out.println("Message: " + e);
         }   
      }
      str = "-----------\n";
      data = str.getBytes();
      output = null;
      try
      {
         output = new 
            BufferedOutputStream(Files.newOutputStream(file, APPEND));
         output.write(data);
         output.flush();
         output.close();
      }
      catch(Exception c)
      {
         System.out.println("Message: " + c);
      }
   }
   public int compLength(int nElems)
   {
      int n=1;
      int j=1;
      int l;
      for(int i=1;i<=nElems;i++)
      {
         n = n*i;
      }
      for(int i=1;i<=(nElems-2);i++)
      {
         j = j*i;
      }
      l = (2*(n/(2*(j))))/6;
      System.out.println(nElems); //debuging purposes only
      System.out.println(l);        //
      System.out.println(n);        //
      System.out.println(j);        //
      return(l); 
   }
   public static int matchCount(int int1, int int2, Path file,String[] arr)
   {
      Path files = file;
      int tempInt1= int1;
      int tempInt2= int2;
      int i=0;
      String s = "";
      InputStream input = null;
      System.out.println("inside");
      try
      {
         input = Files.newInputStream(files);
         BufferedReader reader = new
            BufferedReader(new InputStreamReader(input));
         s = reader.readLine();
         System.out.println(arr[int1]+" vs "+arr[int2] + " :)");
         while(s != null)
         {
            System.out.println(s);
            if((s.equals(arr[int1]+" vs "+arr[int2]))==true || 
               (s.equals(arr[int2]+" vs "+arr[int1]))==true)
            {
               System.out.println("quack!");
               i++;
               if(i>=2)
                  break;
            }
            s = reader.readLine();
         }
         input.close();
      }
      catch(IOException e)
      {
         System.out.println(e);
      }
      if(i>=2)
      {
         return 2;
      }
      else
      {
      return 1;
      }
   }
}