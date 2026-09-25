package task15;
public class StackAdapter implements ISimpleStack {
    private final LegacyArrayStack legacyArrayStack;
    public StackAdapter(LegacyArrayStack legacyArrayStack) {
        this.legacyArrayStack = legacyArrayStack;
    }
    @Override
    public void push(int value) {
        legacyArrayStack.pushInt(value);
    }
    @Override
    public int pop() {
        return legacyArrayStack.popInt();
    }
    @Override
    public boolean isEmpty() {
        return legacyArrayStack.count() == 0;
    }
}