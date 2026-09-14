public class DayChaseStrategy extends ChaseStrategy {
    @Override
    protected boolean canMoveThisTick(Zombie self) {
        return self.consumeSlowTick(); // only allowed to move every 2nd tick during the day
    }
}