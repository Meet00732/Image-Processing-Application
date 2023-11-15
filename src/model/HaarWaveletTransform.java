package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HaarWaveletTransform {
  public static List<Double> T(List<Double> s) {
    List<Double> avg = new ArrayList<>();
    List<Double> diff = new ArrayList<>();
    double sqrtTwo = Math.sqrt(2);

    for (int i = 0; i < s.size(); i += 2) {
      double a = s.get(i);
      double b = (i + 1 < s.size()) ? s.get(i + 1) : 0;

      avg.add((a + b) / sqrtTwo);
      diff.add((a - b) / sqrtTwo);
    }
    avg.addAll(diff);
    return avg;
  }

  public static List<Double> I(List<Double> s) {
    List<Double> originalSequence = new ArrayList<>();
    int halfSize = s.size() / 2;
    double sqrtTwo = Math.sqrt(2);

    for (int i = 0; i < halfSize; i++) {
      double a = s.get(i);
      double b = s.get(i + halfSize);

      originalSequence.add((a + b) / sqrtTwo);
      originalSequence.add((a - b) / sqrtTwo);
    }
    return originalSequence;
  }

  public static double[][] padArray(double[][] X) {
    int width = X.length;
    int height = X[0].length;
    int newDim = powerOfTwo(Math.max(width, height));

    double[][] paddedArray = new double[newDim][newDim];
    for (int i = 0; i < width; i++) {
      System.arraycopy(X[i], 0, paddedArray[i], 0, width);
    }
    return paddedArray;
  }

  private static int powerOfTwo(int number) {
    int power = 1;
    while (power < number) {
      power = power << 1;
    }
    return power;
  }


  public static List<Double> transform(List<Double> s, int l) {
    List<Double> transformedS= new ArrayList<>(s);
    int m = l;
    while (m > 1) {
      List<Double> temp = T(transformedS.subList(0, m));
      for (int i = 0; i < m; i++) {
        transformedS.set(i, temp.get(i));
      }
      m /= 2;
    }
    return transformedS;
  }

  public static List<Double> invert(List<Double> transformedSequence, int l) {
    List<Double> originalSequence = new ArrayList<>(transformedSequence);
    int m = 2;
    while (m <= l) {
      List<Double> temp = I(originalSequence.subList(0, m));
      for (int i = 0; i < m; i++) {
        originalSequence.set(i, temp.get(i));
      }
      m *= 2;
    }
    return originalSequence;
  }

  public static double[][] haar(double[][] X) {
    X = padArray(X);
    int c = X.length;
    while (c > 1) {
      for (int i = 0; i < c; i++) {
        List<Double> row = new ArrayList<>();
        for (int j = 0; j < c; j++) {
          row.add(X[i][j]);
        }
        List<Double> transformedRow = transform(row, c);
        for (int j = 0; j < c; j++) {
          X[i][j] = transformedRow.get(j);
        }
      }
      for (int j = 0; j < c; j++) {
        List<Double> column = new ArrayList<>();
        for (int i = 0; i < c; i++) {
          column.add(X[i][j]);
        }
        List<Double> transformedColumn = transform(column, c);
        for (int i = 0; i < c; i++) {
          X[i][j] = transformedColumn.get(i);
        }
      }
      c = c / 2;
    }
    return X;
  }

  public static double[][] inverseHaar(double[][] X) {
    int c = 2;
    int s = X.length;
    while (c <= s) {
      for (int j = 0; j < c; j++) {
        List<Double> column = new ArrayList<>();
        for (int i = 0; i < c; i++) {
          column.add(X[i][j]);
        }
        List<Double> invertedColumn = invert(column, c);
        for (int i = 0; i < c; i++) {
          X[i][j] = invertedColumn.get(i);
        }
      }
      for (int i = 0; i < c; i++) {
        List<Double> row = new ArrayList<>();
        for (int j = 0; j < c; j++) {
          row.add(X[i][j]);
        }
        List<Double> invertedRow = invert(row, c);
        for (int j = 0; j < c; j++) {
          X[i][j] = invertedRow.get(j);
        }
      }
      c = c * 2;
    }
    return X;
  }

  public static double[][] truncate(double[][] channel, double threshold) {
    int height = channel.length;
    int width = channel[0].length;

    // Create an array of absolute values
    double[] absValues = new double[height * width];
    int index = 0;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        absValues[index++] = channel[i][j];
      }
    }

    // Sort the absolute values to find the threshold
    Arrays.sort(absValues);
    double thresholdValue = absValues[(int) (height * width * (1 - threshold))];

    // Truncate values below the threshold
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (Math.abs(channel[i][j]) < thresholdValue) {
          channel[i][j] = 0.0;
        }
      }
    }
    return channel;
  }
}


//  public static void main(String[] args) {
//    HaarWavelet wavelet = new HaarWavelet();
//
//    // Create a sample 2D array
//    double[][] originalArray = {
////            {5, 2, 1, 4},
////            {3, 8, 6, 7},
////            {2, 1, 4, 0},
////            {9, 5, 3, 2}
//
//            {5,3,2,4,2,1,0,3}
//    };
//
////    double[][] paddedArray = wavelet.padArray(originalArray);
//
//    // The size should now be based on the new dimensions of the padded array
//    int size = originalArray.length;
//
//    // Display the padded array
//    System.out.println("Padded Array:");
//    printArray(originalArray);
//
//    // Apply the Haar wavelet transform
//    double[][] transformedArray = wavelet.haar(originalArray, size);
//
//    // Display the transformed array
//    System.out.println("Transformed Array:");
//    printArray(transformedArray);
//
//    // Apply inverse Haar wavelet transform to recover the original array
//    double[][] recoveredArray = wavelet.inverseHaar(transformedArray, size);
//
//    // Display the recovered array
//    System.out.println("Recovered Array:");
//    printArray(recoveredArray);
//  }
//
//  // Helper method to print a 2D array
//  public static void printArray(double[][] array) {
//    for (int i = 0; i < array.length; i++) {
//      for (int j = 0; j < array[i].length; j++) {
//        System.out.print(array[i][j] + "\t");
//      }
//      System.out.println();
//    }
//    System.out.println();
//  }
