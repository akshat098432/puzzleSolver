import java.sql.Array;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer> perms = new ArrayList<>();
    private static int[] x1 = {1,2};
    private static int[] x2 = {4,2};

    public static void main(String[] args){


        int[][][] piece1 = {{{0,0},{0,1},{1,0},{2,0},{2,1}}, {{0,0},{0,1},{1,1},{2,0},{2,1}}, {{0,0},{0,2},{1,0},{1,1},{1,2}}, {{0,0},{0,1},{0,2},{1,0},{1,2}}};
        int[][][] piece2 = {{{0,0},{1,0},{2,0},{3,0},{3,1}}, {{0,1},{1,1},{2,1},{3,1},{3,0}}, {{0,3},{1,0},{1,1},{1,2},{1,3}}, {{0,0},{0,1},{0,2},{0,3},{1,3}}, {{0,0},{0,1},{1,1},{2,1},{3,1}}, {{0,0},{1,0},{2,0},{3,0},{0,1}}, {{0,0},{0,1},{0,2},{0,3},{1,0}}, {{0,0},{1,0},{1,1},{1,2},{1,3}}};
        int[][][] piece3 = {{{0,0},{1,0},{1,1},{2,1},{3,1}}, {{0,1},{1,0},{1,1},{2,0},{3,0}}, {{0,1},{0,2},{0,3},{1,0},{1,1}}, {{0,0},{0,1},{1,1},{1,2},{1,3}}, {{0,0},{1,0},{2,0},{2,1},{3,1}}, {{0,1},{1,1},{2,1},{2,0},{3,0}}, {{0,2},{0,3},{1,0},{1,1},{1,2}}, {{0,0},{0,1},{0,2},{1,2},{1,3}}};
        int[][][] piece4 = {{{0,0},{1,0},{2,0},{3,0},{1,1}}, {{0,1},{1,0},{1,1},{2,1},{3,1}}, {{0,1},{1,0},{1,1},{1,2},{1,3}}, {{0,0},{0,1},{0,2},{0,3},{1,1}}, {{0,1},{1,1},{2,1},{3,1},{2,0}}, {{0,0},{1,0},{2,0},{3,0},{2,1}}, {{0,0},{0,1},{0,2},{0,3},{1,2}}, {{0,2},{1,0},{1,1},{1,2},{1,3}}};
        int[][][] piece5 = {{{0,0},{0,1},{0,2},{1,0},{2,0}}, {{0,0},{1,0},{2,0},{2,1},{2,2}}, {{0,2},{1,2},{2,0},{2,1},{2,2}}, {{0,0},{0,1},{0,2},{1,2},{2,2}}};
        int[][][] piece6 = {{{0,0},{0,1},{1,0},{1,1},{2,1}}, {{0,0},{0,1},{1,1},{1,0},{2,0}}, {{0,0},{0,1},{1,1},{1,0},{0,2}}, {{0,0},{0,1},{1,1},{1,0},{1,2}}, {{0,0},{1,0},{2,0},{1,1},{2,1}}, {{0,1},{1,0},{2,0},{1,1},{2,1}}, {{1,0},{0,1},{0,2},{1,1},{1,2}}, {{0,0},{0,1},{0,2},{1,1},{1,2}}};
        int[][][] piece7 = {{{2,0},{0,1},{1,1},{2,1},{0,2}}, {{0,0},{0,1},{1,1},{2,1},{2,2}}, {{0,0},{1,0},{1,1},{1,2},{2,2}}, {{0,2},{1,0},{1,1},{1,2},{2,0}}};
        int[][][] piece8 = {{{0,0},{0,1},{1,0},{1,1},{2,0},{2,1}}, {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2}}};

        permfinder("12345678", "");

        int test = 0;

        outer:
        for (int[][] a: piece1){
            for (int[][] b: piece2){
                for (int[][] c: piece3){
                    for (int[][] d: piece4){
                        for (int[][] e: piece5){
                            for (int[][] f: piece6){
                                for (int[][] g: piece7){
                                    for (int[][] h: piece8){
                                        for (int i = 0; i < perms.size(); i++){
                                            int[][] board = {{0, 0, 0, 0, 0, 0},
                                                            {0, 0, 0, 0, 0, 0},
                                                            {0, 0, 0, 0, 0, 0, 0},
                                                            {0, 0, 0, 0, 0, 0, 0},
                                                            {0, 0, 0, 0, 0, 0, 0},
                                                            {0, 0, 0, 0, 0, 0, 0},
                                                            {0, 0, 0}};

                                            int permutation = perms.get(i);
                                            int[][][] store = {a,b,c,d,e,f,g,h};
                                            int[][][] shuffle = new int[8][][];
                                            int count = 0;

                                            while(permutation>0){
                                                int index = permutation%10;
                                                shuffle[count] = store[index-1];
                                                count++;
                                                permutation/=10;
                                            }

                                            int times = 0;


                                            for (int j = 0; j < shuffle.length; j++){
                                                boolean check = addpiece(shuffle[j], board);
                                                if (check) times++;
                                            }

                                            if (times==8){
                                                System.out.println("done!");
                                                break outer;
                                            }

                                            test++;
                                            if (test%10000000 == 0){
                                                System.out.println(test);
                                            }


                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }






    }

    public static void permfinder(String num, String add){
        if (num.length() == 0){
            perms.add(Integer.parseInt(add));
            return;
        }

        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);

            String exclude = num.substring(0, i) + num.substring(i + 1);
            permfinder(exclude, add + digit);
        }
    }


    public static boolean addpiece(int[][] piece, int[][] board){
        boolean check = false;

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (isValid(piece, board, i, j)){
                    check = true;
                    for (int a = 0; a < piece.length; a++){
                        board[i+piece[a][0]][j+piece[a][1]] = 1;
                    }
                }
            }
        }

        return check;
    }

    public static boolean isValid(int[][] piece, int[][] board, int i, int j){
        for (int a = 0; a < piece.length; a++){
            if ((piece[a][0]+i) >= board.length){
               return false;
            }
            if (piece[a][1]+j >= board[piece[a][0]+i].length){
                return false;
            }
        }
        for (int a = 0; a < piece.length; a++){
            if ((board[piece[a][0]+i][piece[a][1]+j] == 1) || ((piece[a][0]+i) == x1[0] && (piece[a][1]+j) == x1[1]) || ((piece[a][0]+i) == x2[0] && (piece[a][1]+j) == x2[1])){
                return false;
            }
        }
        return true;
    }
}
