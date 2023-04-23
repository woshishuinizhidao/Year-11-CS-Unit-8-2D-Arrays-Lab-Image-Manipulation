package image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSobel extends Canvas {
    JFrame jframe = new JFrame("figureSobelDealing");
    BufferedImage bufferedImage,bufferedImage_gray,bufferedImage_sobel;
    Image image,image_gray,image_sobel;
    int rgb[][][],width,height;
    BufferedImage bufferedImage_end;

    public ImageSobel(){
        try {
            bufferedImage = ImageIO.read(new File("./cyberpunk2077.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = bufferedImage.getWidth();
        height =bufferedImage.getHeight();

        bufferedImage_end = new BufferedImage(width,height, BufferedImage.TYPE_3BYTE_BGR );
        rgb = new int[width+1][height+1][1];
        jframe.setLayout(null);

        jframe.setBounds(0,0,width,height);
        this.setBounds(0,0,width,height);
        jframe.add(this);
        jframe.setVisible(true);
        bufferedImage_gray =gray(bufferedImage);
        bufferedImage_end = sobel(bufferedImage_gray);

        try{
            ImageIO.write(bufferedImage_end,"png",new File("face9.png"));
            System.out.println("modified picture saved");
        } catch(IOException e){
            System.out.println("error");
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        image =(Image)bufferedImage;
        bufferedImage_gray =gray(bufferedImage);
        image_sobel =(Image)sobel(bufferedImage_gray);
        g.drawImage(image,0,0,null);
        g.drawLine(350,10,350,600);
        g.drawImage(image_sobel,370,0,null);
    }


    public BufferedImage gray(BufferedImage b){
        bufferedImage_gray = new BufferedImage(width,height, BufferedImage.TYPE_3BYTE_BGR );

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(bufferedImage.getRGB(x,y));
                int gray = (int)(color.getRed() * 0.299 + color.getGreen() * 0.587 + color.getBlue() *0.114);
                Color color_end = new Color(gray,gray,gray);
                bufferedImage_gray.setRGB(x,y,color_end.getRGB());
                rgb[x][y][0] = gray;
            }
        }
        return bufferedImage_gray;
    }

    public BufferedImage sobel(BufferedImage bufferedImage){
        bufferedImage_sobel = new BufferedImage(width,height, BufferedImage.TYPE_3BYTE_BGR );

        for (int y = 1; y < height-1; y++) {
            for (int x = 1; x < width-1; x++) {
                int Gx = rgb[x+1][y-1][0] +2*rgb[x+1][y][0]+rgb[x+1][y+1][0]-rgb[x-1][y-1][0] -2*rgb[x-1][y][0]-rgb[x-1][y+1][0];
                int Gy = rgb[x-1][y-1][0] +2*rgb[x][y-1][0]+rgb[x+1][y-1][0] -rgb[x-1][y+1][0] - 2*rgb[x][y+1][0] -rgb[x+1][y+1][0];

                if (Gx < 0){
                    Gx = -1*Gx;
                }

                if (Gy <0){
                    Gy = -1*Gy;
                }
                int s = Gx +Gy;

                if (s < 148){
                    s = 255;
                }else{
                    s = 0;
                }
                Color color = new Color(s,s,s);
                bufferedImage_sobel.setRGB(x,y,color.getRGB());
            }
        }
        return bufferedImage_sobel;
    }


}