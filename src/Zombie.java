public class Zombie extends Entity {

    private boolean isDaytime = false;
    private int daySlowCounter = 0;

    public Zombie(int x, int y) {
        super(x, y, "\uD83E\uDDDF"); // 🧟
    }

    // Overloaded constructor: build a Zombie directly from a Human that just got infected
    public Zombie(Human infectedHuman) {
        super(infectedHuman.getX(), infectedHuman.getY(), "\uD83E\uDDDF");
    }

    // Called by GamePanel before move(), same pattern as Human.setVisibleCures().
    public void setDaytime(boolean isDaytime) {
        this.isDaytime = isDaytime;
    }

    // Package-private: only the strategy classes need this, it's an
    // implementation detail of HOW slowing works, not something outside
    // code should be able to read or reset directly.
    boolean consumeSlowTick() {
        daySlowCounter++;
        if (daySlowCounter < 4) return false;
        daySlowCounter = 0;
        return true;
    }

    @Override
    public void move(int gridWidth, int gridHeight, Entity[] allEntities, boolean[][] blocked) {
        ZombieStrategy strategy = isDaytime ? new DayChaseStrategy() : new NightChaseStrategy();
        strategy.move(this, gridWidth, gridHeight, allEntities, blocked);
    }
}