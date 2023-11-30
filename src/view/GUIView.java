package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Optional;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Features;

public class GUIView extends JFrame implements GUIInterface {

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

    redButton = new JButton("Red");
    buttonPanel.add(redButton);

    greenButton = new JButton("Green");
    buttonPanel.add(greenButton);

    blueButton = new JButton("Blue");
    buttonPanel.add(blueButton);

    blurButton = new JButton("Blur");
    buttonPanel.add(blurButton);

    sepiaButton = new JButton("Sepia");
    buttonPanel.add(sepiaButton);

    lumaButton = new JButton("Luma");
    buttonPanel.add(lumaButton);

    sharpenButton = new JButton("Sharpen");
    buttonPanel.add(sharpenButton);

    horizontalFlipButton = new JButton("Horizontal-Flip");
    buttonPanel.add(horizontalFlipButton);

    verticalFlipButton = new JButton("Vertical-Flip");
    buttonPanel.add(verticalFlipButton);

    compressButton = new JButton("Compress");
    buttonPanel.add(compressButton);

    colorCorrectedButton = new JButton("Color-Corrected");
    buttonPanel.add(colorCorrectedButton);

    adjustLevelsButton = new JButton("Adjust-Levels");
    buttonPanel.add(adjustLevelsButton);

    saveButton = new JButton("Save");
    buttonPanel.add(saveButton);

    confirmButton = new JButton("Confirm");
    confirmButton.setVisible(false);
    buttonPanel.add(confirmButton);

    cancelButton = new JButton("Cancel");
    cancelButton.setVisible(false);
    buttonPanel.add(cancelButton);

//    getCommand();

    add(buttonPanel, BorderLayout.SOUTH);


    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }


  @Override
  public void addFeatures(Features features) {
    loadButton.addActionListener(evt -> features.loadButton());
    blurButton.addActionListener(evt -> features.blurButton());
    sepiaButton.addActionListener(evt -> features.sepiaButton());
    redButton.addActionListener(evt -> features.redButton());
    greenButton.addActionListener(evt -> features.greenButton());
    blueButton.addActionListener(evt -> features.blueButton());
    lumaButton.addActionListener(evt -> features.lumaButton());
    sharpenButton.addActionListener(evt -> features.sharpenButton());
    compressButton.addActionListener(evt -> features.compressButton());
    colorCorrectedButton.addActionListener(evt -> features.colorCorrectedButton());
    adjustLevelsButton.addActionListener(evt -> features.adjustLevelsButton());
    horizontalFlipButton.addActionListener(evt -> features.horizontalFlipButton());
    verticalFlipButton.addActionListener(evt -> features.verticalFlipButton());
    saveButton.addActionListener(evt -> features.saveButton());
    cancelButton.addActionListener(evt -> features.cancelButton());
    confirmButton.addActionListener(evt -> features.confirmButton());
  }


  @Override
  public void setImage(BufferedImage image) {
    imageDisplay.setIcon(new ImageIcon(image));
  }

  @Override
  public void setHistogram(BufferedImage histogram) {
    histogramDisplay.setIcon(new ImageIcon(histogram));
  }

  @Override
  public String loadImagePath() {
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

  @Override
  public String saveImagePath() {
    JFileChooser fileChooser = new JFileChooser();
    String currentDirectory = System.getProperty("user.dir");
    fileChooser.setCurrentDirectory(new File(currentDirectory));
    fileChooser.setDialogTitle("Save Image");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.setAcceptAllFileFilterUsed(false);
    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image files",
            "jpg", "jpeg", "png", "ppm"));

    fileChooser.setSelectedFile(new File("Untitled.jpg"));

    if (fileChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
      return null;
    }

    File file = fileChooser.getSelectedFile();
    if (!file.getName().toLowerCase().matches(".*\\.(jpg|jpeg|png|ppm)$")) {
      file = new File(file.getAbsolutePath() + ".jpg");
    }
    return file.getAbsolutePath();
  }

  @Override
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

  @Override
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


  @Override
  public Optional<Double> promptPercentage() {
    String result = JOptionPane.showInputDialog(this,
            "Enter percentage:");
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

  @Override
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
    JOptionPane.showMessageDialog(null, message, "Error",
            JOptionPane.ERROR_MESSAGE);
  }
}
