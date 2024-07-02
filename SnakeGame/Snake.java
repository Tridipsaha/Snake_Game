public class Snake  {

    int x;
    int y;
    

    Snake(Border br) {

        x = br.rn/2;
        y= br.cn /2;
        

    }

    int [] SnakeHeadPositon(){
        int [] pos = new int[2];
        pos[0] = x;
        pos[1] = y;

        return pos;

        
    }


    public static void main(String[] args) {

    }

}
