/*
<metadata>
<name>Different queries</name>
<url>https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/practice-problems/algorithm/jumbled-queries-afb23321/?purpose=login&source=problem-page&update=google</url>
<status>Completed</status>
<date>2026-07-07</date>
<level>Medium</level>
</metadata>
*/
import java.io.*;
import java.util.*;

public class Main {

    static long[] A;

    static class Query {
        int x, l, r;

        Query(int x, int l, int r) {
            this.x = x;
            this.l = l;
            this.r = r;
        }
    }

    static ArrayList<Query> negativeAdd = new ArrayList<>();
    static ArrayList<Query> positiveAdd = new ArrayList<>();
    static ArrayList<Query> allSet = new ArrayList<>();

    static void addQueries(ArrayList<Query> queries) {
        for (Query q : queries) {
            for (int i = q.l; i <= q.r; i++) {
                A[i] += q.x;
            }
        }
    }

    static void setQueries(ArrayList<Query> queries) {
        for (Query q : queries) {
            for (int i = q.l; i <= q.r; i++) {
                A[i] = q.x;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        A = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (type == 1) {
                if (x < 0)
                    negativeAdd.add(new Query(x, l, r));
                else
                    positiveAdd.add(new Query(x, l, r));
            } else {
                allSet.add(new Query(x, l, r));
            }
        }

        Collections.sort(allSet, Comparator.comparingInt(q -> q.x));

        addQueries(negativeAdd);
        setQueries(allSet);
        addQueries(positiveAdd);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(A[i]).append(" ");
        }

        System.out.println(sb);
    }
}