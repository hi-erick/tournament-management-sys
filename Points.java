import java.util.ArrayList; 
import java.util.List; 
 
public enum Points { 
    Win(5), 
    Draw(3), 
    Bye(0), 
    Lose(1); 
 
    private int value; 
    Points(int point) { 
        value = point; 
    } 
 
    public int get() { 
        return value; 
    } 
 
    public void set(int point) { 
        value = point; 
    } 
 
    public static List<Points> getPointsNames() { 
        List<Points> list = new ArrayList<>(); 
        list.add(Points.Lose); 
        list.add(Points.Win); 
        list.add(Points.Draw); 
        return list; 
    } 
}
