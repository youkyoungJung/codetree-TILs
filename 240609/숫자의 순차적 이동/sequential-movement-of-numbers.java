import java.io.*;
import java.util.*;

public class Main {

    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static class Location {
        int r;
        int c;

        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(m-- > 0){
            for(int k = 1; k <= n*n; k++){
                Location maxL = new Location(-1, -1);
                int max = Integer.MIN_VALUE;

                out:for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(arr[i][j] == k){
                            
                            for(int d = 0; d < 8; d++){
                                int nr = i + dist[d][0];
                                int nc = j + dist[d][1];

                                if(checked(nr, nc)){
                                    if(max < arr[nr][nc]){
                                        max = arr[nr][nc];
                                        maxL.r = nr;
                                        maxL.c = nc;
                                    }
                                }

                            } // dist 8

                            //switch
                            int temp = arr[i][j];
                            if(maxL.r > -1 && maxL.c > -1){
                                arr[i][j] = arr[maxL.r][maxL.c];
                                arr[maxL.r][maxL.c] = temp; 
                            }
                            break out;
                        
                        }
                    }
                }
            }
        }

        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
       
        System.out.println(sb.toString());
    }

    static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n;
    }

}