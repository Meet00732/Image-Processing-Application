package model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HistogramCreator {

  public static BufferedImage createHistogramImage(Image image) {
    int[] redFrequency = new int[256];
    int[] greenFrequency = new int[256];
    int[] blueFrequency = new int[256];

    Pixel[][] pixels = image.getPixels();
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[i].length; j++) {
        Pixel pixel = pixels[i][j];
        redFrequency[pixel.getRed()]++;
        greenFrequency[pixel.getGreen()]++;
        blueFrequency[pixel.getBlue()]++;
      }
    }

    int maxFrequency = getMaxFrequency(redFrequency, greenFrequency, blueFrequency);

    BufferedImage histogramImage = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = histogramImage.createGraphics();
    g2d.setColor(Color.WHITE);
    g2d.fillRect(0, 0, 256, 256);

    drawGrid(g2d);

    drawHistogram(g2d, redFrequency, maxFrequency, Color.RED);
    drawHistogram(g2d, greenFrequency, maxFrequency, Color.GREEN);
    drawHistogram(g2d, blueFrequency, maxFrequency, Color.BLUE);

    g2d.dispose();

    return histogramImage;
  }

  private static void drawGrid(Graphics2D g2d) {
    g2d.setColor(Color.LIGHT_GRAY);
    for (int i = 0; i < 256; i += 16) {
      g2d.drawLine(i, 0, i, 255); // vertical lines
      g2d.drawLine(0, i, 255, i); // horizontal lines
    }
  }

  private static void drawHistogram(Graphics2D g2d, int[] frequency, int maxFrequency, Color color) {
    g2d.setColor(color);
    int prevX = 0;
    int prevY = 255;

    for (int i = 0; i < frequency.length; i++) {
      int x = i;
      int y = (int) ((frequency[i] / (double) maxFrequency) * 255);

      g2d.drawLine(prevX, prevY, x, 255 - y);

      prevX = x;
      prevY = 255 - y;
    }
  }

  private static int getMaxFrequency(int[]... frequencies) {
    int max = 0;
    for (int[] frequency : frequencies) {
      for (int value : frequency) {
        if (value > max) {
          max = value;
        }
      }
    }
    return max;
  }
}
