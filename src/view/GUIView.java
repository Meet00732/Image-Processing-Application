package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUIView extends JFrame implements ImageViewInterface {

  private JLabel imageDisplay;
  private JLabel histogramDisplay;
  private JButton loadButton, blurButton, saveButton, confirmButton, cancelButton;

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
    imageDisplay.setPreferredSize(new Dimension(700, 500));
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

    displayPanel.setPreferredSize(new Dimension(956, 500));
    add(displayPanel, BorderLayout.CENTER);

    makeButtons();

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void makeButtons() {
    JPanel buttonPanel = new JPanel(new FlowLayout());
    loadButton = new JButton("Load");
    buttonPanel.add(loadButton);
    loadButton.setActionCommand("load");

    blurButton = new JButton("Blur");
    buttonPanel.add(blurButton);
    blurButton.setActionCommand("blur");

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

  public void setBlurButtonActionListener(ActionListener listener) {
    blurButton.addActionListener(listener);
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

  public void showOperationControls(boolean show) {
    confirmButton.setVisible(show);
    cancelButton.setVisible(show);
    loadButton.setEnabled(!show);
    blurButton.setEnabled(!show);
  }

  @Override
  public String getCommand() {
    return null;
  }

  @Override
  public void display(String message) {

  }
}
