import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        StringSorter ss = new StringSorter();

        //read the strings from the file
        ss.read("src/test.txt");

        ss.sortStrings(ss.list.size());

        ss.write("src/sorted.txt");
    }


}