package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HaarWavelet {
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
      System.arraycopy(X[i], 0, paddedArray[i], 0, height);
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
    List<Double> transformedS = new ArrayList<>(s);
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
        List<Double> col = new ArrayList<>();
        for (int i = 0; i < c; i++) {
          col.add(X[i][j]);
        }
        List<Double> transformedCol = transform(col, c);
        for (int i = 0; i < c; i++) {
          X[i][j] = transformedCol.get(i);
        }
      }
      c = c / 2;
    }
    return X;
  }

  public static double[][] unpadArray(double[][] X, int originalWidth, int originalHeight) {
    double[][] unpaddedArray = new double[originalWidth][originalHeight];
    for (int i = 0; i < originalWidth; i++) {
      System.arraycopy(X[i], 0, unpaddedArray[i], 0, originalHeight);
    }
    return unpaddedArray;
  }

  public static double[][] inverseHaar(double[][] X, int originalWidth, int originalHeight) {
    int c = 2;
    int s = X.length;
    while (c <= s) {
      for (int j = 0; j < c; j++) {
        List<Double> col = new ArrayList<>();
        for (int i = 0; i < c; i++) {
          col.add(X[i][j]);
        }
        List<Double> invertedCol = invert(col, c);
        for (int i = 0; i < c; i++) {
          X[i][j] = invertedCol.get(i);
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
    return unpadArray(X, originalWidth, originalHeight);
  }

  public static double calculateThreshold(double[][] redChannel, double[][] greenChannel, double[][] blueChannel, double percentage) {
    Set<Double> uniqueValues = new HashSet<>();
    for (double[][] channel : new double[][][]{redChannel, greenChannel, blueChannel}) {
      for (double[] array : channel) {
        for (double value : array) {
          uniqueValues.add(Math.abs(value));
        }
      }
    }

    List<Double> sortedUniqueValues = new ArrayList<>(uniqueValues);
    Collections.sort(sortedUniqueValues);

    int thresholdIndex = (int) (sortedUniqueValues.size() * (percentage / 100.0));
    thresholdIndex = Math.min(thresholdIndex, sortedUniqueValues.size() - 1);

    return sortedUniqueValues.get(thresholdIndex);
  }


  public static double[][] truncate(double[][] channel, double threshold) {
    int width = channel.length;
    int height = channel[0].length;

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        if (Math.abs(channel[i][j]) < threshold) {
          channel[i][j] = 0.0;
        }
      }
    }
    return channel;
  }




//  public static void main(String[] args) {
//    double[][] originalArray = {
//            {5, 2, 1, 4},
//            {3, 8, 6, 7},
//            {2, 1, 4, 0},
//            {9, 5, 3, 2}
//
////            {5,3,2,4,2,1,0,3}
//    };
//
//    int size = originalArray.length;
//
//
//    System.out.println("Padded Array:");
//    printArray(originalArray);
//
//    double[][] transformedArray = haar(originalArray);
//
//    System.out.println("Transformed Array:");
//    printArray(transformedArray);
//
//
//    double[][] recoveredArray = inverseHaar(transformedArray);
//
//    System.out.println("Recovered Array:");
//    printArray(recoveredArray);
//  }
//
//  public static void printArray(double[][] array) {
//    for (int i = 0; i < array.length; i++) {
//      for (int j = 0; j < array[i].length; j++) {
//        System.out.print(array[i][j] + "\t");
//      }
//      System.out.println();
//    }
//    System.out.println();
//  }
}
