package org.tiscs.reststack.core.generic;

public class DataFilter<TL, TR> {
    private TL left;
    private TR right;
    private DataFilterOperator operator;

    public DataFilter(TL left, TR right, DataFilterOperator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public TL getLeft() {
        return left;
    }

    public TR getRight() {
        return right;
    }

    public DataFilterOperator getOperator() {
        return operator;
    }
}
