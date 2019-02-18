import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FrameTest {
    private var frame: Frame? = null

    @Before
    fun setUp() {
        frame = Frame()
    }

    @Test
    fun `when starts starts with 0`() {
        assertEquals(0, frame?.score)
    }


    @Test
    fun `when set pins frame sets game status`() {
        frame?.setPinsKnockedDown(10)
        assertEquals(Status.STRIKE, frame?.status)
    }

    @Test
    fun `when one throw and not strike then frame not complete`() {
        frame?.setPinsKnockedDown(2)
        assertEquals(Status.INCOMPLETE, frame?.status)
    }

    @Test
    fun `when two throws and not strike then frame complete`() {
        frame?.setPinsKnockedDown(2)
        frame?.setPinsKnockedDown(2)
        assertEquals(Status.DONE, frame?.status)
    }

    @Test(expected = IllegalGameException::class)
    fun `when three throws and not strike then exception`() {
        frame?.setPinsKnockedDown(2)
        frame?.setPinsKnockedDown(2)
        frame?.setPinsKnockedDown(2)
    }

    @Test(expected = IllegalGameException::class)
    fun `when more thhan ten exception is thrown`() {
        frame?.setPinsKnockedDown(11)
    }

    @Test(expected = IllegalGameException::class)
    fun `when less than 0 exception is thrown`() {
        frame?.setPinsKnockedDown(-1)
    }

    @Test(expected = IllegalGameException::class)
    fun `when more than ten in two rolls exception is thrown`() {
        frame?.setPinsKnockedDown(10)
        frame?.setPinsKnockedDown(1)
    }

    @Test(expected = IllegalGameException::class)
    fun `when more than ten in two rolls exception is thrown inverted`() {
        frame?.setPinsKnockedDown(1)
        frame?.setPinsKnockedDown(10)
    }

    @Test
    fun `when 10 in two throws is spare`() {
        frame?.setPinsKnockedDown(8)
        frame?.setPinsKnockedDown(2)
        assertEquals(Status.SPARE, frame?.status)
    }
}

