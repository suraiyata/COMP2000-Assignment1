import java.awt.Graphics2D;

// The State pattern's contract. Each concrete state decides what a logic
// tick does (step) and what gets drawn on top of the world (render).
// Defaults mean a state only has to override what it actually cares about.
public interface GameState {
    default void step(GamePanel panel) { }

    void render(Graphics2D g2, GamePanel panel);

    default boolean isGameOver() {
        return false;
    }

    String getName();
}