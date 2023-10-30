package controller.features;

import java.io.IOException;

import model.Image;

public interface ImageParserInterface {

  Image load() throws IOException;

  void save(String path, Image image) throws Exception;

}
