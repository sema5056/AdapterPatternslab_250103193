package task07;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class InventoryIteratorAdapter implements IInventoryIteratorProvider {
    private final LegacyInventory legacyInventory;
    public InventoryIteratorAdapter(LegacyInventory legacyInventory) {
        this.legacyInventory = legacyInventory;
    }

    @Override
    public Iterator<String> getInventoryIterator() {
        Enumeration<String> enumeration = legacyInventory.getCatalogEnumeration();
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }
            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return enumeration.nextElement();
            }
        };
    }
}