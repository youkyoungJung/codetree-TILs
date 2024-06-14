import java.util.*;
import java.io.*;

public class Main {
    static class Location {
        int r;
        int c;

        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> newOne = new ArrayDeque<>();
        int[][] arr = new int[5][5];

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            newOne.offer(Integer.parseInt(st.nextToken()));
        }

        while(k-- > 0){
            int maxScore = 0;
            int[][] maxArr = new int[5][5];

            for(int i = 0; i < 3; i++){ //90, 180, 270
                for(int r = 0; r <= 2; r++){
                    for(int c = 0; c <= 2; c++){
                        int[][] rotated = rotate(r, c, i, arr);
                        int score = calcScore(rotated);
                        if(maxScore < score){
                            maxScore = score;
                            maxArr = rotated;
                        }
                    }
                }
            }

            if(maxArr[0][0] == 0){ // 더 이상 획득 못한경우
                break;
            }

            arr = maxArr;
            while(true){
                arr = fill(newOne, arr);
                int newScore = calcScore(arr);
                if(newScore == 0) break;
                maxScore += newScore;
            }

            sb.append(maxScore).append(" ");

        }
        System.out.println(sb.toString());
    }

    public static int[][] fill(Queue<Integer> queue, int[][] arr){
        for(int j = 0; j < 5; j++){
            for(int i = 4; i >= 0; i--){
                if(arr[i][j] == 0 && !queue.isEmpty()){
                    arr[i][j] = queue.poll();
                }
            }
        }
        return arr;
    }

    static boolean[][] isVisited;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int calcScore(int[][] arr){
        int score = 0;
        isVisited = new boolean[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(!isVisited[i][j]){
                    //bfs
                    Queue<Location> queue = new ArrayDeque<>();
                    Queue<Location> trace = new ArrayDeque<>();
                    queue.offer(new Location(i, j));
                    queue.offer(new Location(i, j));
                    isVisited[i][j] = true;

                    while(!queue.isEmpty()){
                        Location current = queue.poll();
                        int target = arr[current.r][current.c];
                        for(int d = 0; d < 4; d++){
                            int nr = current.r + dist[d][0];
                            int nc = current.c + dist[d][1];

                            if(isChecked(nr, nc) && arr[nr][nc] == target){
                                queue.offer(new Location(nr, nc));
                                trace.offer(new Location(nr, nc));
                                isVisited[nr][nc] = true;
                            }
                        }
                    }
                    
                    if(trace.size()>=3){
                        score += trace.size();

                        while(!trace.isEmpty()){
                            Location current = trace.poll();
                            arr[current.r][current.c] = 0;
                        }

                    }
                }
            }
        }
        return score;
    } // end of clac

    public static boolean isChecked(int r, int c){
        return r >= 0 && r < 5 && c >= 0 && c < 5 && !isVisited[r][c];
    }

    //rotate(r, c, i, arr);
    public static int[][] rotate(int r, int c, int l, int[][] arr){
        
        int[][] result = new int[5][5];
        int n = arr.length;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                result[i][j] = arr[i][j];
            }
        }

        for(int i = r; i < r+3; i++){
            for(int j = c; j < c+3; j++){
                if(l == 0){ //90도
                    result[i][j] = arr[n-1-j][i];
                }else if(l == 1){ //180도
                    result[i][j] = arr[n-1-i][n-1-j];
                }else{ //270도
                    result[i][j] = arr[j][n-1-i];
                }
            }
        }

        return result;
    }

}//end of class