package programmers.implementation.rotate;

// 행렬 테두리 회전하기
public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] Graph;

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(6, 6, new int[][]{{2,2,5,4}, {3,3,6,6},{5,1,6,3}});
        for(int a : answer){
            System.out.println(a);
        }
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;
        init(rows, columns);
        int startX, startY, endX, endY;
        for(int[] query: queries){
            startX = query[0] - 1;
            startY = query[1] - 1;
            endX = query[2] - 1;
            endY = query[3] - 1;
            answer[idx++] = rotate(startX, startY, endX, endY);
            draw();
            System.out.println();
        }
        // int[] query = queries[0];
        // startX = query[0] - 1;
        // startY = query[1] - 1;
        // endX = query[2] - 1;
        // endY = query[3] - 1;
        // answer[idx++] = rotate(startX, startY, endX, endY);
        return answer;
    }

    static int rotate(int sr, int sc, int er, int ec){
        int idx = 0;
        int start = Graph[sr][sc];
        int min = start;
        int currentY = sr;
        int currentX = sc;
        int nextY = sr + dy[idx];
        int nextX = sc + dx[idx];
        while(!(nextY == sr && nextX == sc)){
            if(nextX + dx[idx] < sc || nextX + dx[idx] > ec || nextY + dy[idx] < sr || nextY + dy[idx] > er){
                idx = (idx + 1) % 4;
            }
            // 좌표 값 변경
            Graph[currentY][currentX] = Graph[nextY][nextX];

            // min 확인
            if(min > Graph[currentY][currentX]) min = Graph[currentY][currentX];

            // 칸 이동
            currentY = nextY;
            currentX = nextX;

            // 다음 좌표 설정
            nextY = currentY + dy[idx];
            nextX = currentX + dx[idx];
        }
        Graph[currentY][currentX] = start;
        return min;
    }

    static void init(int r, int c){
        Graph = new int[r][c];
        int num = 1;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                Graph[i][j] = num++;
            }
        }
    }

    static void draw(){
        for(int i=0;i<Graph.length;i++){
            for(int j=0;j<Graph[0].length;j++){
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}