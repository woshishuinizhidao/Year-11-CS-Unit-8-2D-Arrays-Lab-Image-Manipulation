package code;

import image.APImage;
import image.ImageSobel;
import image.ImagePanel;
import image.Pixel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageManipulation {

    private static int[][][] rgb;

    /**
     * CHALLENGE 0: Display Image
     * Write a statement that will display the image in a window
     */
    public static void main(String[] args) {
//challenge 0:
        JFrame frame = new JFrame("challenge");
        frame.setSize(1392, 884);
        Image image = new ImageIcon("cyberpunk2077.jpg").getImage();
        ImagePanel imagePanel = new ImagePanel(image, 1392, 884);
        frame.getContentPane().add(imagePanel);
        frame.setVisible(true);


        //challenge 1
        File file1 = new File("C:\\Users\\yun\\Desktop\\cyberpunk2077.jpg\"");
        String file1Parent = file1.getParent();

        grayScale(file1Parent);
        //challenge 2
        blackAndWhite(file1Parent);
        //challenge 3
        edgeDetection(file1Parent, 20);


    }

    /**
     * CHALLENGE ONE: Grayscale
     * <p>
     * INPUT: the complete path file name of the image
     * OUTPUT: a grayscale copy of the image
     * <p>
     * To convert a colour image to grayscale, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * Set the red, green, and blue components to this average value.
     */
    public static void grayScale(String pathOfFile) {
        APImage image = new APImage();
        for (Pixel p : image) {
            int red = p.getRed();
            int green = p.getGreen();
            int blue = p.getBlue();
            int average = (red + green + blue) / 3;
            p.setRed(average);
            p.setGreen(average);
            p.setBlue(average);
        }
        image.draw();
    }


    /**
     * A helper method that can be used to assist you in each challenge.
     * This method simply calculates the average of the RGB values of a single pixel.
     *
     * @param pixel
     * @return the average RGB value
     */
    private static int getAverageColour(Pixel pixel) {
        return 0;
    }

    /**
     * CHALLENGE TWO: Black and White
     * <p>
     * INPUT: the complete path file name of the image
     * OUTPUT: a black and white copy of the image
     * <p>
     * To convert a colour image to black and white, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * If the average is less than 128, set the pixel to black
     * If the average is equal to or greater than 128, set the pixel to white
     */
    public static void blackAndWhite(String pathOfFile) {

        APImage image = new APImage();
        for (Pixel p : image) {
            int red = p.getRed();
            int green = p.getGreen();
            int blue = p.getBlue();
            int average = (red + green + blue) / 3;
            if (average > 128) {
                average = 255;
            } else {
                average = 0;
            }
            p.setBlue(average);
            p.setGreen(average);
            p.setRed(average);

        }
        image.draw();


    }

    /**
     * CHALLENGE Three: Edge Detection
     * <p>
     * INPUT: the complete path file name of the image
     * OUTPUT: an outline of the image. The amount of information will correspond to the threshold.
     * <p>
     * Edge detection is an image processing technique for finding the boundaries of objects within images.
     * It works by detecting discontinuities in brightness. Edge detection is used for image segmentation
     * and data extraction in areas such as image processing, computer vision, and machine vision.
     * <p>
     * There are many different edge detection algorithms. We will use a basic edge detection technique
     * For each pixel, we will calculate ...
     * 1. The average colour value of the current pixel
     * 2. The average colour value of the pixel to the left of the current pixel
     * 3. The average colour value of the pixel below the current pixel
     * If the difference between 1. and 2. OR if the difference between 1. and 3. is greater than some threshold value,
     * we will set the current pixel to black. This is because an absolute difference that is greater than our threshold
     * value should indicate an edge and thus, we colour the pixel black.
     * Otherwise, we will set the current pixel to white
     * NOTE: We want to be able to apply edge detection using various thresholds
     * For example, we could apply edge detection to an image using a threshold of 20 OR we could apply
     * edge detection to an image using a threshold of 35
     */
    public static void edgeDetection(String pathToFile, int threshold) {
        new ImageSobel();

//        APImage image = new APImage();

//        for (Pixel p : image) {
//            p.clone();
//            int red = p.getRed()-threshold;
//            int green = p.getGreen()-threshold;
//            int blue = p.getBlue()-threshold;
//
//            int average = (red + green + blue) / 3;
//            if (average > 128) {
//                average = 0;
//            } else {
//                average = 255;
//
//            }
//            p.setBlue(average);
//            p.setGreen(average);
//            p.setRed(average);
//
//        }
//        image.draw();


    }

    /**
     * CHALLENGE Four: Reflect Image
     * <p>
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     */
    public static void reflectImage(String pathToFile) {

    }

    /**
     * CHALLENGE Five: Rotate Image
     * <p>
     * INPUT: the complete path file name of the image
     * OUTPUT: the image rotated 90 degrees CLOCKWISE
     */
    public static void rotateImage(String pathToFile) {

    }

}
