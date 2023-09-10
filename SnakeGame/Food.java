import java.util.Random;

public class Food {

    int min = 2;
    int rowMax;
    int colMax;

    Food( Border br) {

        this.rowMax = br.rn - 2;
        this.colMax = br.cn - 2;

    }


    int[] foodRandPositon() {
        Random random = new Random();

        int[] positon = new int[2];

        // Generate a random integer within the specified range
        positon[0] = random.nextInt(rowMax - min + 1) + min;
        positon[1] = random.nextInt(colMax - min + 1) + min;

        return positon;
    }






























    public static void main(String[] args) {
        // Food fd = new Food();

        // int [] pos = fd.foodRandPositon();

        // System.out.println(pos[0] + " " + pos[1]);
    }

}
