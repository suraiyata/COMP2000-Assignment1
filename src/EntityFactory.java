// Centralises how Human, Zombie, and Cure objects get created.
//
// This is the Factory Method pattern: calling code asks the factory for an
// entity rather than calling "new" directly. Before this class existed,
// human<->zombie conversion logic (including syncing the render position so
// the sprite doesn't visually jump) was duplicated separately in
// handleInfections() and handleCures(). Centralising it here means that
// logic exists in exactly one place, and any future change to how a
// conversion works only needs to happen once.
public class EntityFactory {

    public static Human createHuman(int x, int y) {
        return new Human(x, y);
    }

    public static Zombie createZombie(int x, int y) {
        return new Zombie(x, y);
    }

    // Converts an infected Human into a Zombie at the same position,
    // preserving its current on-screen render position so it doesn't jump.
    public static Zombie convertToZombie(Human h) {
        Zombie z = new Zombie(h);
        z.syncRenderPosition(h.getRenderX(), h.getRenderY());
        return z;
    }

    // Converts a cured Zombie back into a Human at the same position,
    // preserving its current on-screen render position.
    public static Human convertToHuman(Zombie z) {
        Human h = new Human(z.getX(), z.getY());
        h.syncRenderPosition(z.getRenderX(), z.getRenderY());
        return h;
    }

    public static Cure createCure(int x, int y) {
        return new Cure(x, y);
    }
}
