import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends Frame implements KeyListener {

    static Border br;
    static Food fd;
    static Snake s;

    static int headX;
    static int headY;

    static int foodX;
    static int foodY;

    static int size = 0;

    static String currentDirection = "";
    static String previousKey ="";
    private boolean isMoving = false;

    static int []prevHead = new int[2];

    public static void main(String[] args) {
        br = new Border(20, 50);
        fd = new Food(br);
        s = new Snake(br);

        int[] hpos = s.SnakeHeadPositon();
        headX = hpos[0];
        headY = hpos[1];

        int[] pos = fd.foodRandPositon();
        foodX = pos[0];
        foodY = pos[1];

        br.BorderFoodPlot(foodX, foodY);

        br.BorderHeadPlot(headX, headY);

        br.Disp();

        new Main();

    }

    Label i;
    TextArea area;

    Main() {

        i = new Label();
        i.setBounds(0, 0, 0, 0);

        area = new TextArea();
        area.setBounds(0, 0, 0, 0);

        area.addKeyListener(this);

        add(i);
        add(area);
        setSize(0, 0);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int key = e.getKeyCode();
        String keyType = KeyEvent.getKeyText(key);

        if ("Up".equals(keyType) || "Down".equals(keyType) || "Left".equals(keyType) || "Right".equals(keyType)) {
            if (!isMoving) {
                isMoving = true;
                currentDirection = keyType;

                Runnable moveRunnable = createMovementRunnable();
                new Thread(moveRunnable).start();
            } else {
                previousKey = currentDirection;
                prevHead[0] = headX;
                prevHead[1] = headY;
                currentDirection = keyType;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // i.setText("keyReleased");

    }


 private Runnable createMovementRunnable() {
        return () -> {
            while (true) {

                br.tailRemove(prevHead, size, previousKey);


                switch (currentDirection) {
                    case "Up":
                        headX--;
                        br.BorderHeadUp(headX, headY, size);
                        

                        if (headX == foodX && headY == foodY) {
                            int[] pos = fd.foodRandPositon();
                            foodX = pos[0];
                            foodY = pos[1];

                            br.BorderFoodPlot(foodX, foodY);
                            size++;
                        }
                        br.Disp();
                        
                        break;

                    case "Down":
                        headX++;
                        br.BorderHeadDown(headX, headY, size);

                        if (headX == foodX && headY == foodY) {
                            int[] pos = fd.foodRandPositon();
                            foodX = pos[0];
                            foodY = pos[1];

                            br.BorderFoodPlot(foodX, foodY);
                            size++;
                        }
                        br.Disp();

                        break;

                    case "Left":
                        headY--;
                        br.BorderHeadLeft(headX, headY, size);

                        if (headX == foodX && headY == foodY) {
                            int[] pos = fd.foodRandPositon();
                            foodX = pos[0];
                            foodY = pos[1];

                            br.BorderFoodPlot(foodX, foodY);
                            size++;

                        }
                        br.Disp();
                        break;

                    case "Right":
                        headY++;
                        br.BorderHeadRight(headX, headY, size);

                        if (headX == foodX && headY == foodY) {
                            int[] pos = fd.foodRandPositon();
                            foodX = pos[0];
                            foodY = pos[1];

                            br.BorderFoodPlot(foodX, foodY);
                            size++;

                        }
                        br.Disp();
                        break;
                }

                try {
                    Thread.sleep(200);
                } catch (Exception e) {

                }
            }
        };
    }




}
