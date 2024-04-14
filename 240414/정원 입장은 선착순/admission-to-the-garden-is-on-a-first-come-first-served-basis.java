import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static PriorityQueue<int[]> pQue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    static PriorityQueue<int[]> tempQue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    static int maxtime;
    static int[] timearr = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            int t = scanner.nextInt();

            timearr[i] = t;
            // 도착시간, 번호
            pQue.add(new int[]{a, i});
        }

        int max = 0;
        while (!pQue.isEmpty()) {
            // 정원에 입장하기 위해서 기다려야 할 사람들
            while (!pQue.isEmpty()) {
                int[] person = pQue.peek();
                int arrivetime = person[0];
                if (arrivetime > maxtime) break;

                // 번호, 도착시간
                tempQue.add(new int[]{person[1], arrivetime});
                pQue.poll();
            }

            // 기다려야할 사람이 있다면
            if (!tempQue.isEmpty()) {
                // 도착 시간
                int[] tempPerson = tempQue.poll();
                int a = tempPerson[1];
                // 머물 시간
                int t = timearr[tempPerson[0]];
                // 입장하기 위해 기다린 경우
                if (maxtime > a) {
                    max = Math.max(max, maxtime - a);
                    maxtime += t;
                }
                // 안기다린 경우
                else
                    maxtime = a + t;
            }
            // 없다면
            else {
                // 도착 시간
                int[] person = pQue.poll();
                int a = person[0];
                // 머물 시간
                int t = timearr[person[1]];
                // 최초 입장인 경우
                if (maxtime == 0)
                    maxtime = a + t;
                else {
                    // 입장하기 위해 기다린 경우
                    if (maxtime > a) {
                        max = Math.max(max, maxtime - a);
                        maxtime += t;
                    }
                    // 안기다린 경우
                    else
                        maxtime = a + t;
                }
            }
        }

        System.out.println(max);
    }
}