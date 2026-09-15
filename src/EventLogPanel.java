import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// Displays a scrolling, timestamped log of simulation events such as
// infections, cures being used, and the eventual winner.
//
// EventLogPanel implements SimulationListener, so it can be registered
// directly with a GamePanel (gamePanel.addListener(this)) and will
// automatically receive every event the panel announces.
public class EventLogPanel extends JPanel implements SimulationListener {

    private final DefaultListModel<String> model = new DefaultListModel<>();
    private final JList<String> list = new JList<>(model);
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    private static final int MAX_ENTRIES = 200;

    public EventLogPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Event Log"));

        list.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(240, 180));
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void onEvent(String message) {
        SwingUtilities.invokeLater(() -> {
            String timestamp = timeFormat.format(new Date());
            model.addElement("[" + timestamp + "] " + message);

            if (model.size() > MAX_ENTRIES) {
                model.remove(0);
            }

            list.ensureIndexIsVisible(model.size() - 1);
        });
    }

    public void clear() {
        SwingUtilities.invokeLater(model::clear);
    }
}
