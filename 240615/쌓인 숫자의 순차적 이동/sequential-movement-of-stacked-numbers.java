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

    static final Location OUT_OF_GRID = new Location(-1, -1);
    static int n;
    static List<Integer>[][] arr;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< n; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j].add(num);
            }
        }

        st = new StringTokenizer(br.readLine());
        while(m-- > 0){
            int targetNum = Integer.parseInt(st.nextToken());
            simulation(targetNum);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j].size() == 0){
                    sb.append("None").append("\n");
                }else{
                    for(int k = arr[i][j].size()-1; k >= 0; k--){
                        sb.append(arr[i][j].get(k)).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());

    }//end of main

    public static void simulation(int targetNum){

        Location findLocation = new Location(0, 0);
        //숫자 위치 찾기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < arr[i][j].size(); k++){
                    if(arr[i][j].get(k) == targetNum){
                        findLocation.r = i;
                        findLocation.c = j;
                    }
                }
            }
        }

        //가장 큰위치 찾기
        Location maxLocation = goFindMax(findLocation);

        //이동하기
        if(maxLocation != OUT_OF_GRID){
            move(findLocation, maxLocation, targetNum);
        }
    } //end of simulation

    public static void move(Location findLocation, Location maxLocation, int targetNum){
        int r = findLocation.r;
        int c = findLocation.c;

        int nr = maxLocation.r;
        int nc = maxLocation.c;

        boolean toMove = false;
        for(int i = 0; i < arr[r][c].size(); i++) {
            if(arr[r][c].get(i) == targetNum)
                toMove = true;
            
            if(toMove)
                arr[nr][nc].add(arr[r][c].get(i));
        }
        
        
        while(arr[r][c].get(arr[r][c].size()-1) != targetNum){
            arr[r][c].remove(arr[r][c].size()-1);
        }
        arr[r][c].remove(arr[r][c].size()-1);
    }

    public static Location goFindMax(Location location){
        int[][] dist = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        Location findMax = OUT_OF_GRID;
        int maxVal = Integer.MIN_VALUE;

        for(int i = 0; i < 8; i++){
            int nr = location.r + dist[i][0];
            int nc = location.c + dist[i][1];

            if(checked(nr, nc)){
                for(int j = 0; j < arr[nr][nc].size(); j++){
                    if(arr[nr][nc].get(j) > maxVal){
                        maxVal = arr[nr][nc].get(j);
                        findMax = new Location(nr, nc);
                    }
                }
            }
        }
        return findMax;
    }

    public static boolean checked(int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }



}//end of class