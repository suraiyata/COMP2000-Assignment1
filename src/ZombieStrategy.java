// Behaviour contract for how a Zombie decides its next move.
// Mirrors Human's MovementStrategy interface: a class implementing this
// says HOW a zombie moves, without Zombie needing to know the details.
public interface ZombieStrategy {
    void move(Zombie self, int gridWidth, int gridHeight, Entity[] allEntities, boolean[][] blocked);
}