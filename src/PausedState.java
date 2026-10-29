import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class PausedState implements GameState {
    @Override
    public void render(Graphics2D g2, GamePanel panel) {
        int size = panel.getWorldPixelSize();

        g2.setColor(new Color(0, 0, 0, 130));
        g2.fillRect(0, 0, size, size);

        String text = "PAUSED";
        g2.setFont(new Font("SansSerif", Font.BOLD, 36));
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(text);

        g2.setColor(Color.WHITE);
        g2.drawString(text, (size - textWidth) / 2, size / 2);
    }

    @Override
    public String getName() {
        return "Paused";
    }
}