public class NightChaseStrategy extends ChaseStrategy {
    @Override
    protected boolean canMoveThisTick(Zombie self) {
        return true; // full speed at night
    }
}