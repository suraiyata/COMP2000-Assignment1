// Shared chase logic for both day and night. The only thing that differs
// between day and night is WHETHER the zombie is allowed to move this tick,
// so that single decision is the one abstract method subclasses must provide.
public abstract class ChaseStrategy implements ZombieStrategy {

    @Override
    public void move(Zombie self, int gridWidth, int gridHeight, Entity[] allEntities, boolean[][] blocked) {
        if (!canMoveThisTick(self)) return;

        Human target = Entity.findNearest(allEntities, Human.class, self.getX(), self.getY());
        if (target == null) return;

        int[] next = PathFinder.findNextStep(self.getX(), self.getY(), target.getX(), target.getY(), blocked, gridWidth);
        if (next == null) return;

        if (!Entity.isTileOccupiedBy(Zombie.class, next[0], next[1], allEntities, self)) {
            self.planPosition(next[0], next[1]);
        }
    }

    protected abstract boolean canMoveThisTick(Zombie self);
}