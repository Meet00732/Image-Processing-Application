package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Optional;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUIView extends JFrame implements ImageViewInterface {

  private JLabel imageDisplay;
  private JLabel histogramDisplay;
  private JButton loadButton, blurButton, saveButton, confirmButton, cancelButton,
                  sepiaButton, redButton, greenButton, blueButton, horizontalFlipButton,
                  verticalFlipButton, lumaButton, sharpenButton, compressButton,
                  colorCorrectedButton, adjustLevelsButton;

  public GUIView() {
    initializeUI();
  }

  private void initializeUI() {
    setTitle("Image Processor");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    JPanel displayPanel = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    JPanel imagePanel = new JPanel(new BorderLayout());
    JLabel imageHeading = new JLabel("Image Display");
    imageHeading.setHorizontalAlignment(JLabel.CENTER);
    imageDisplay = new JLabel();
    imageDisplay.setHorizontalAlignment(JLabel.CENTER);
    imageDisplay.setPreferredSize(new Dimension(900, 600));
    JScrollPane imageScrollPane = new JScrollPane(imageDisplay);
    imagePanel.add(imageHeading, BorderLayout.NORTH);
    imagePanel.add(imageScrollPane, BorderLayout.CENTER);

    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 0.75;
    c.weighty = 1.0;
    c.fill = GridBagConstraints.BOTH;
    displayPanel.add(imagePanel, c);

    JPanel histogramPanel = new JPanel(new BorderLayout());
    JLabel histogramHeading = new JLabel("Histogram");
    histogramHeading.setHorizontalAlignment(JLabel.CENTER);
    histogramDisplay = new JLabel();
    histogramDisplay.setHorizontalAlignment(JLabel.CENTER);
    histogramDisplay.setPreferredSize(new Dimension(256, 256));
    JScrollPane histogramScrollPane = new JScrollPane(histogramDisplay);
    histogramPanel.add(histogramHeading, BorderLayout.NORTH);
    histogramPanel.add(histogramScrollPane, BorderLayout.CENTER);

    c.gridx = 1;
    c.gridy = 0;
    c.weightx = 0.25;
    c.weighty = 1.0;
    c.fill = GridBagConstraints.BOTH;
    displayPanel.add(histogramPanel, c);

    displayPanel.setPreferredSize(new Dimension(1000, 500));
    add(displayPanel, BorderLayout.CENTER);

    makeButtons();

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void makeButtons() {
    JPanel buttonPanel = new JPanel();
    int numberOfButtons = 16;
    int rows = 2;
    int cols = (int) Math.ceil((double) numberOfButtons / rows);
    buttonPanel.setLayout(new GridLayout(rows, cols));
    
    loadButton = new JButton("Load");
    buttonPanel.add(loadButton);
    loadButton.setActionCommand("load");

    redButton = new JButton("Red");
    buttonPanel.add(redButton);
    redButton.setActionCommand("red");

    greenButton = new JButton("Green");
    buttonPanel.add(greenButton);
    greenButton.setActionCommand("green");

    blueButton = new JButton("Blue");
    buttonPanel.add(blueButton);
    blueButton.setActionCommand("blue");

    blurButton = new JButton("Blur");
    buttonPanel.add(blurButton);
    blurButton.setActionCommand("blur");

    sepiaButton = new JButton("Sepia");
    buttonPanel.add(sepiaButton);
    sepiaButton.setActionCommand("sepia");

    lumaButton = new JButton("Luma");
    buttonPanel.add(lumaButton);
    lumaButton.setActionCommand("luma");

    sharpenButton = new JButton("Sharpen");
    buttonPanel.add(sharpenButton);
    sharpenButton.setActionCommand("sharpen");

    horizontalFlipButton = new JButton("Horizontal-Flip");
    buttonPanel.add(horizontalFlipButton);
    horizontalFlipButton.setActionCommand("horizontal-flip");

    verticalFlipButton = new JButton("Vertical-Flip");
    buttonPanel.add(verticalFlipButton);
    verticalFlipButton.setActionCommand("vertical-flip");

    compressButton = new JButton("Compress");
    buttonPanel.add(compressButton);
    compressButton.setActionCommand("compress");

    colorCorrectedButton = new JButton("Color-Corrected");
    buttonPanel.add(colorCorrectedButton);
    colorCorrectedButton.setActionCommand("color-corrected");

    adjustLevelsButton = new JButton("Adjust-Levels");
    buttonPanel.add(adjustLevelsButton);
    adjustLevelsButton.setActionCommand("adjust-levels");

    saveButton = new JButton("Save");
    buttonPanel.add(saveButton);
    saveButton.setActionCommand("save");

    confirmButton = new JButton("Confirm");
    confirmButton.setActionCommand("confirm");
    confirmButton.setVisible(false);
    buttonPanel.add(confirmButton);

    cancelButton = new JButton("Cancel");
    cancelButton.setActionCommand("cancel");
    cancelButton.setVisible(false);
    buttonPanel.add(cancelButton);

    add(buttonPanel, BorderLayout.SOUTH);

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void setLoadButtonActionListener(ActionListener listener) {
    loadButton.addActionListener(listener);
  }

  public void setRedButtonActionListener(ActionListener listener) {
    redButton.addActionListener(listener);
  }

  public void setGreenButtonActionListener(ActionListener listener) {
    greenButton.addActionListener(listener);
  }

  public void setBlueButtonActionListener(ActionListener listener) {
    blueButton.addActionListener(listener);
  }

  public void setBlurButtonActionListener(ActionListener listener) {
    blurButton.addActionListener(listener);
  }

  public void setSepiaButtonActionListener(ActionListener listener) {
    sepiaButton.addActionListener(listener);
  }

  public void setLumaButtonActionListener(ActionListener listener) {
    lumaButton.addActionListener(listener);
  }

  public void setSharpenButtonActionListener(ActionListener listener) {
    sharpenButton.addActionListener(listener);
  }

  public void setHorizontalFlipButtonActionListener(ActionListener listener) {
    horizontalFlipButton.addActionListener(listener);
  }

  public void setVerticalFlipButtonActionListener(ActionListener listener) {
    verticalFlipButton.addActionListener(listener);
  }

  public void setCompressButtonActionListener(ActionListener listener) {
    compressButton.addActionListener(listener);
  }

  public void setColorCorrectedButtonActionListener(ActionListener listener) {
    colorCorrectedButton.addActionListener(listener);
  }

  public void setAdjustLevelsButtonActionListener(ActionListener listener) {
    adjustLevelsButton.addActionListener(listener);
  }

  public void setSaveButtonActionListener(ActionListener listener) {
    saveButton.addActionListener(listener);
  }

  public void setConfirmButtonActionListener(ActionListener listener) {
    confirmButton.addActionListener(listener);
  }

  public void setCancelButtonActionListener(ActionListener listener) {
    cancelButton.addActionListener(listener);
  }

  public void setImage(BufferedImage image) {
    imageDisplay.setIcon(new ImageIcon(image));
  }

  public void setHistogram(BufferedImage histogram) {
    histogramDisplay.setIcon(new ImageIcon(histogram));
  }

  public String loadImage() {
    JFileChooser fileChooser = new JFileChooser();

    String currentDirectory = System.getProperty("user.dir");
    fileChooser.setCurrentDirectory(new File(currentDirectory));

    fileChooser.setDialogTitle("Open Image File");
    fileChooser.setAcceptAllFileFilterUsed(false);
    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image files",
            "jpg", "jpeg", "png", "ppm"));

    if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      return file.getAbsolutePath();
    }
    return null;
  }

  public String saveImage() {
    JFileChooser fileChooser = new JFileChooser();
    String currentDirectory = System.getProperty("user.dir");
    fileChooser.setCurrentDirectory(new File(currentDirectory));
    fileChooser.setDialogTitle("Save Image");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.setAcceptAllFileFilterUsed(false);
    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image files",
            "jpg", "jpeg", "png", "ppm"));

    // Suggest a default filename, like "Untitled.jpg"
    fileChooser.setSelectedFile(new File("Untitled.jpg"));

    if (fileChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
      return null; // User canceled the operation
    }

    File file = fileChooser.getSelectedFile();
    // Ensure the file has an appropriate extension
    if (!file.getName().toLowerCase().matches(".*\\.(jpg|jpeg|png|ppm)$")) {
      file = new File(file.getAbsolutePath() + ".jpg"); // Default to .jpg if no extension is provided
    }

    return file.getAbsolutePath();
  }



  public void showOperationControls(boolean show) {
    confirmButton.setVisible(show);
    cancelButton.setVisible(show);
    loadButton.setEnabled(!show);
    blurButton.setEnabled(!show);
    saveButton.setEnabled(!show);
    sepiaButton.setEnabled(!show);
    redButton.setEnabled(!show);
    greenButton.setEnabled(!show);
    blueButton.setEnabled(!show);
    horizontalFlipButton.setEnabled(!show);
    verticalFlipButton.setEnabled(!show);
    lumaButton.setEnabled(!show);
    sharpenButton.setEnabled(!show);
    compressButton.setEnabled(!show);
    colorCorrectedButton.setEnabled(!show);
    adjustLevelsButton.setEnabled(!show);
  }

  public boolean confirmImageLoad() {
    int choice = JOptionPane.showConfirmDialog(
            this,
            "Are you sure? The current image is not saved!",
            "Confirm Load",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
    );

    return choice == JOptionPane.YES_OPTION;
  }


  public Optional<Double> promptSplitPercentage() {
    String result = JOptionPane.showInputDialog(this,
            "Enter split percentage:");
    try {
      Optional<Double> percentage = Optional.ofNullable(result).map(Double::parseDouble);

      if (percentage.isPresent() && (percentage.get() < 0 || percentage.get() > 100)) {
        display("Percentage must be between 0 and 100.");
        return Optional.empty();
      }

      return percentage;
    } catch (NumberFormatException e) {
      display("Invalid percentage format.");
      return Optional.empty();
    }
  }

  public Optional<int[]> promptForAdjustLevels() {
    int b, m, w;

    try {
      String resultB = JOptionPane.showInputDialog(this, "Enter value for b:");
      b = Integer.parseInt(resultB);
      if (b < 0 || b > 255) {
        display("Value of b must be in the range of 0 to 255!");
        return Optional.empty();
      }

      String resultM = JOptionPane.showInputDialog(this, "Enter value for m:");
      m = Integer.parseInt(resultM);
      if (m < 0 || m > 255) {
        display("Value of m must be in the range of 0 to 255!");
        return Optional.empty();
      }

      String resultW = JOptionPane.showInputDialog(this, "Enter value for w:");
      w = Integer.parseInt(resultW);
      if (w < 0 || w > 255) {
        display("Value of w must be in the range of 0 to 255!");
        return Optional.empty();
      }

      if (b >= m || m >= w) {
        display("Values must be in the range 0 to 255 and satisfy b < m < w!");
        return Optional.empty();
      }

      return Optional.of(new int[]{b, m, w});
    } catch (NumberFormatException e) {
      display("Invalid input. Please enter integer values.");
    }
    return Optional.empty();
  }


  @Override
  public String getCommand() {
    return null;
  }

  @Override
  public void display(String message) {
    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
  }
}
