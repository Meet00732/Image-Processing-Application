import org.junit.Before;
import org.junit.Test;

import controller.commands.CommandFactory;
import controller.commands.CommandPair;
import model.ImageModelInterface;
import model.MockModel;
import view.GUIInterface;
import view.MockView;

import static org.junit.Assert.*;

public class CommandFactoryTest {

  private ImageModelInterface model;
  private GUIInterface view;
  private CommandFactory commandFactory;

  @Before
  public void setUp() {
    model = new MockModel();
    view = new MockView();
    commandFactory = new CommandFactory(model, view);
  }

  /**
   * test for InvokeLoadCommand.
   */
  @Test
  public void testInvokeLoadCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeSaveCommand.
   */
  @Test
  public void testInvokeSaveCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("save");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("SaveCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeBlurCommand.
   */
  @Test
  public void testInvokeBlurCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("blur");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("BlurCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeSepiaCommand.
   */
  @Test
  public void testInvokeSepiaCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("sepia");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("SepiaCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeLumaCommand.
   */
  @Test
  public void testInvokeLumaCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("luma");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LumaComponentCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeRedComponentCommand.
   */
  @Test
  public void testInvokeRedComponentCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("red");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("RedComponentCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeGreenComponentCommand.
   */
  @Test
  public void testInvokeGreenComponentCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("green");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("GreenComponentCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeBlueComponentCommand.
   */
  @Test
  public void testInvokeBlueComponentCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("blue");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("BlueComponentCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeHorizontalFlipCommand.
   */
  @Test
  public void testInvokeHorizontalFlipCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("horizontal-flip");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("HorizontalFlipCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeVerticalFlipCommand.
   */
  @Test
  public void testInvokeVerticalFlipCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("vertical-flip");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("VerticalFlipCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeAdjustedLevelsCommand.
   */
  @Test
  public void testInvokeAdjustedLevelsCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("adjust-levels");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LevelsAdjustmentCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeColorCorrectedCommand.
   */
  @Test
  public void testInvokeColorCorrectedCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("color-corrected");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("ColorCorrectionCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeCompressCommand.
   */
  @Test
  public void testInvokeCompressCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("compress");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("CompressCommand", commandPair.getApplyCommand().toString());
  }

  /**
   * test for InvokeSharpenCommand.
   */
  @Test
  public void testInvokeSharpenCommand() {
    CommandPair commandPair = commandFactory.invokeCommand("load");

    assertNotNull(commandPair);
    assertNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("LoadCommand", commandPair.getApplyCommand().toString());

    commandPair = commandFactory.invokeCommand("sharpen");

    assertNotNull(commandPair);
    assertNotNull(commandPair.getPreviewCommand());
    assertNotNull(commandPair.getApplyCommand());
    assertEquals("SharpenCommand", commandPair.getApplyCommand().toString());
  }

}