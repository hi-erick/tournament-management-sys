public class Teams {
    private String[] a;
    private int nElems;

    public Teams(String names) {
        a = new String[10];
    }

    public void insert(String value) {
        a[nElems] = value;
        nElems++;
     }

     //show team names
     public void display() {
        for(int i = 0; i<nElems; i++)  
  }
}