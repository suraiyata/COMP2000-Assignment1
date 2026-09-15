// Receives notifications whenever a significant event occurs during the
// simulation (an infection, a cure being used, a winner being decided, etc).
//
// GamePanel holds a list of these and calls onEvent() on each one whenever
// something noteworthy happens, without needing to know anything about how
// each listener actually displays or uses that information.
//
// This is the Observer pattern: GamePanel is the subject, and anything
// implementing SimulationListener (like EventLogPanel) is an observer.
// New kinds of observers could be added later (a sound player, a stats
// tracker) without ever changing GamePanel's core simulation logic.
public interface SimulationListener {
    void onEvent(String message);
}
