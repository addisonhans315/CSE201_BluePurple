
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VerificationJUnit {

	verification v = new verification("cookece2", "password", "users.txt");

	@Test
	void testGetStatus() {
		assertEquals(2, v.getStatus());
	}

	@Test
	void testVerify() {
		assertTrue(v.verify());
	}

}
