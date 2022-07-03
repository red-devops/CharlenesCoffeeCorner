package model;

import java.util.Objects;

public class ReceiptRow {

    private String rowDescription;
    private double rowValue;

    public ReceiptRow(String rowDescription, double rowValue) {
        this.rowDescription = rowDescription;
        this.rowValue = rowValue;
    }

    public String getReciptRowDescription() {
        return rowDescription;
    }

    public void setRowDescription(String rowDescription) {
        this.rowDescription = rowDescription;
    }

    public double getRowValue() {
        return rowValue;
    }

    public void setRowValue(double rowValue) {
        this.rowValue = rowValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptRow that = (ReceiptRow) o;
        return Double.compare(that.rowValue, rowValue) == 0 && Objects.equals(rowDescription, that.rowDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowDescription, rowValue);
    }
}
