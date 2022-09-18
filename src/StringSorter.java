import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;



public class StringSorter {
    static int MAX = 100;

    ArrayList<String> list;


    public void sortStrings(int n)
    {
        String temp;

        // Sorting strings using bubble sort
        for (int j = 0; j < n - 1; j++)
        {
            for (int i = j + 1; i < n; i++)
            {
                if (list.get(j).compareTo(list.get(i)) > 0)
                {
                    temp = list.get(j);
                    list.set(j,list.get(i));
                    list.set(i,temp);
                }
            }
        }
    }

    //read method reads an array of strings from a file
    public ArrayList<String> read(String filename) throws IOException {
        ArrayList<String> result = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader(filename))) {
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
            list = result;
            return result;
        }
    }



    public void write(String filename) throws IOException
    {
        try(FileWriter writer = new FileWriter("src/sorted.txt"))
        {
            for (String str : list) {
                System.out.println(str);
                writer.write(str + System.lineSeparator());
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
