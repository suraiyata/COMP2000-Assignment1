import java.awt.Graphics2D;

public class RunningState implements GameState {
    @Override
    public void step(GamePanel panel) {
        panel.runSimulationStep();
    }

    @Override
    public void render(Graphics2D g2, GamePanel panel) {
    }

    @Override
    public String getName() {
        return "Running";
    }
}