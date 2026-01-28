package decorators;

import gift.Gift;

/**
 * Concrete Decorator
 * Adds bow functionality to a Gift.
 */
public class BowDecorator extends GiftDecorator {

    public BowDecorator(Gift gift) {
        super(gift);
    }

    @Override
    public String prepare() {
        return gift.prepare() + " with a bow";
    }
}
