// Thrown when the simulation attempts to use a cure on a Human that does
// not actually have one. This should never happen given the current logic
// in handleCures(), but is thrown defensively so that if the surrounding
// code is ever refactored, an inconsistency here fails loudly instead of
// silently curing a zombie that shouldn't have been cured.
//
// A checked exception, not unchecked: this represents a recoverable,
// meaningful failure state in the simulation's data (similar to how
// WorldSetupException represents a recoverable grid-generation failure),
// rather than a plain programming mistake like a bad array index.
public class InvalidCureStateException extends Exception {
    public InvalidCureStateException(String message) {
        super(message);
    }
}
