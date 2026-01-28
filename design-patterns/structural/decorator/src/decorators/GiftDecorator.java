package decorators;

import gift.Gift;

/**
 * Base Decorator
 * Holds a reference to another Gift.
 */
public abstract class GiftDecorator implements Gift {
    protected final Gift gift;

    protected GiftDecorator(Gift gift) {
        this.gift = gift;
    }
}
