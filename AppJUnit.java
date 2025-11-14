
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppJUnit {

	App a = new App("Duo", "/images/duo.png", "utility", "0.0", "2FA", "Duo");

	@Test
	void testGetName() {
		assertEquals("Duo", a.getName());
	}

	@Test
	void testGetImagePath() {
		assertEquals("/images/duo.png", a.getImagePath());
	}

	@Test
	void testGetType() {
		assertEquals("utility", a.getType());
	}

	@Test
	void testGetPrice() {
		assertEquals("0.0", a.getPrice());
	}

	@Test
	void tetsGetDetails() {
		assertEquals("2FA", a.getDetails());
	}

	@Test
	void testGetDeveloper() {
		assertEquals("Duo", a.getDeveloper());
	}

}
