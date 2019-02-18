import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Created by maurizio.pietrantuon on 18/02/2019.
 */
class GameTest {
    val GAME_FRAMES = 10

    @Test
    fun `game has 10 frames`() {
        val game = Game()
        assertEquals(GAME_FRAMES, game.frames.size)
    }


    @Test
    fun `throwing ball updates frame`() {

    }
}

