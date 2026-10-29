import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class GameOverState implements GameState {
    @Override
    public void render(Graphics2D g2, GamePanel panel) {
        int size = panel.getWorldPixelSize();

        g2.setColor(new Color(0, 0, 0, 170));
        g2.fillRect(0, 0, size, size);

        String winnerText = panel.getWinnerText();
        g2.setFont(new Font("SansSerif", Font.BOLD, 40));
        FontMetrics titleFm = g2.getFontMetrics();
        int titleWidth = titleFm.stringWidth(winnerText);
        g2.setColor(Color.WHITE);
        g2.drawString(winnerText, (size - titleWidth) / 2, size / 2 - 10);

        String stats = "Cures used: " + panel.getCuresUsedCount();
        g2.setFont(new Font("SansSerif", Font.PLAIN, 18));
        FontMetrics statsFm = g2.getFontMetrics();
        int statsWidth = statsFm.stringWidth(stats);
        g2.drawString(stats, (size - statsWidth) / 2, size / 2 + 24);
    }

    @Override
    public boolean isGameOver() {
        return true;
    }

    @Override
    public String getName() {
        return "Game Over";
    }
}