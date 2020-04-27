package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class ImageTest {

	@Test
	void test() {
		
		try {
			BufferedImage image2 = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/bulletD.gif"));
			assertNotNull(image2);
		} catch (IOException e) {
			e.getMessage();
		}
	}

}
