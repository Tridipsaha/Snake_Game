class Border {
    String[][] arr = new String[100][100];
    int rn;
    int cn;
    

    Border() {
        rn = 50;
        cn = 40;

        for (int row = 0; row < rn; row++) {

            for (int col = 0; col < cn; col++) {

                if (row == 0 || row == rn - 1)
                    arr[row][col] = "#";

                else
                    arr[row][col] = " ";

                if (row < rn && col == 0 || col == cn - 1)
                    arr[row][col] = "#";

            }

            arr[row][cn] = "#";
        }

    }

    Border(int rowLen, int colLen) {

        this.rn = rowLen;
        this.cn = colLen;

        for (int row = 0; row < rn; row++) {

            for (int col = 0; col < cn; col++) {

                if (row == 0 || row == rn - 1)

                    arr[row][col] = "-";
                else

                    arr[row][col] = " ";

                if (row < rn && col == 0 || col == cn - 1)
                    arr[row][col] = "|";

            }
            arr[row][cn] = "#";
        }

    }

    void Disp() {
        System.out.print("\033[H");
        //System.out.flush();

        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < cn; j++) {
                //System.out.print("\u001b[?215");
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }

    void BorderFoodPlot(int x, int y) {
        arr[x][y] ="*";
    }


    void BorderHeadPlot(int x, int y){
        arr[x][y]= "o";
    }

    void BorderHeadClean(int x, int y){
        arr[x][y]= " ";
    }

    void BorderHeadUp(int x, int y, int size){

        if(size== 0){
            arr[++x][y]= " ";
            arr[--x][y]= "o";
        }else{
            arr[x][y]= "o";
            arr[x+size+1][y] =" ";
        }

    }

    void BorderHeadDown(int x, int y, int size){
        if(size == 0){

            arr[--x][y]= " ";
            arr[++x][y]= "o";
        }else{
            arr[x][y]= "o";
            arr[x-size-1][y] = " ";
        }

    }

    void BorderHeadLeft(int x, int y, int size){
        if(size == 0){

            arr[x][++y]= " ";
            arr[x][--y]= "o";
        }else{
            arr[x][y] = "o";
            arr[x][y+size+1] = " ";

        }

    }

    void BorderHeadRight(int x, int y, int size){
        if(size == 0){

            arr[x][--y]= " ";
            arr[x][++y]= "o";
        }else{
            arr[x][y] = "o";
            arr[x][y-size-1] = " ";

        }

    }


    void tailRemove(int [] prevHead, int size, String key){

        int x = prevHead[0];
        int y = prevHead[1];

        switch (key) {
            case "Up":
                if(size!=0 && prevHead[0]!= -1 && prevHead[1]!= -1){
                    arr[x+size][y] = " ";
                    prevHead[0] = --x;
                }
                break;

            case "Down":
                if(size!=0 && prevHead[0]!= -1 && prevHead[1]!= -1){
                    arr[x-size][y] = " ";
                    prevHead[0] = ++x;
                }
                break;
            
            case "Left":
                if(size!=0 && prevHead[0]!= -1 && prevHead[1]!= -1){
                    arr[x][y-size] = " ";
                    prevHead[1] = ++y;
                }
                break;

            case "Right":
                if(size!=0 && prevHead[0]!= -1 && prevHead[1]!= -1){
                    arr[x][y+size] = " ";
                    prevHead[1] = --y;
                }
                break;
        
            default:
                break;
        }

    }


    



























    public static void main(String[] args) {

        // Border br = new Border(30, 40);
         

    }

}