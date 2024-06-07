import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Person> people = new ArrayList<>();

        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int solve = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken()) % 100;
            char name = st.nextToken().charAt(0);
            Person p = new Person(name, year, solve);
            people.add(p);
        }

        people.sort(Comparator.comparingInt(a -> a.year));
        for(Person p : people) bw.write(String.valueOf(p.year));
        bw.newLine();
        people.sort((a, b) -> b.solve - a.solve);
        for(Person p : people) bw.write(String.valueOf(p.name));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }

    public static class Person {
        public char name;
        public int year;
        public int solve;

        public Person(char name, int year, int solve) {
            this.name = name;
            this.year = year;
            this.solve = solve;
        }
    }
}

