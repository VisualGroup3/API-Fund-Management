package com.group3.fundmgt.manager;

public class ManagerAssetValue {
    private String assetClass;
    private long value;


    public ManagerAssetValue() {
    }

    public ManagerAssetValue(String assetClass, long value) {
        this.assetClass = assetClass;
        this.value = value;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public long getValue() {
        return value;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ManagerAssetValue{" +
                "assetClass='" + assetClass + '\'' +
                ", value=" + value +
                '}';
    }
}
