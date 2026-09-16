import java.util.ArrayList;
import java.util.List;

public class Human extends Entity implements Infectable {

    private boolean infected = false;
    private boolean hasCure = false;

    private List<Cure> visibleCures = new ArrayList<>(); 
    private static final int DETECTION_RADIUS = 8;
    public List<Cure> getVisibleCures() {
        return visibleCures;
    }

    public void setVisibleCures(List<Cure> cures) {
        this.visibleCures = cures;
    }

    public Human(int x, int y) {
        super(x, y, "\uD83E\uDDCD"); // 🧍
    }

    // Overloaded constructor: allow creating a human with a custom emoji
    public Human(int x, int y, String customEmoji) {
        super(x, y, customEmoji);
    }
    public boolean hasCure() {
        return hasCure;
    }

    public void giveCure() {
        this.hasCure = true;
        this.emoji = "\uD83E\uDDD1\u200D\u2695\uFE0F"; //🧑‍⚕️
    }

    public void useCure() {
        this.hasCure = false;
        this.emoji = "\uD83E\uDDCD"; //🧍
    }

    @Override public void move(int gridWidth, int gridHeight, Entity[] allEntities, boolean[][] blocked) {
        MovementStrategy strategy;
        if (hasCure) {
            strategy = new DeliverCureStrategy();
        } else {
            Zombie nearestZombie = Entity.findNearest(allEntities, Zombie.class, gridX, gridY);
            Cure nearestCure = findNearestCure();
            boolean zombieNear = nearestZombie != null && distanceTo(nearestZombie.getX(), nearestZombie.getY()) <= DETECTION_RADIUS;
            boolean cureNear = nearestCure != null && distanceTo(nearestCure.getX(), nearestCure.getY()) <= DETECTION_RADIUS;
            if (zombieNear) {
                strategy = new FleeStrategy(); 
            } else if (cureNear) {
                strategy = new SeekCureStrategy();
            } else {
                strategy = new WanderStrategy();
            }
        } 
        strategy.move(this, gridWidth, gridHeight, allEntities, blocked);
    }
    private int distanceTo(int x, int y) {
        return Math.abs(x - gridX) + Math.abs(y - gridY);
    } 
    private Cure findNearestCure() {
        Cure nearest = null;
        int bestDist = Integer.MAX_VALUE;
        for (Cure c : visibleCures) {
            int dist = distanceTo(c.getX(), c.getY());
            if (dist < bestDist) {
                bestDist = dist;
                nearest = c;
            }
        }
    return nearest;
    }

    @Override
    public void infect() {
        this.infected = true;
    }

    @Override
    public boolean isInfected() {
        return infected;
    }
}