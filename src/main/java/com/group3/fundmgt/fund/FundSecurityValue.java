package com.group3.fundmgt.fund;

public class FundSecurityValue {
    private String securitySymble;
    private long value;

    public FundSecurityValue() {
    }

    public FundSecurityValue(String securitySymble, long value) {
        this.securitySymble = securitySymble;
        this.value = value;
    }

    public String getSecuritySymble() {
        return securitySymble;
    }

    public long getValue() {
        return value;
    }

    public void setSecuritySymble(String securitySymble) {
        this.securitySymble = securitySymble;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "FundSecurityValue{" +
                "securitySymble='" + securitySymble + '\'' +
                ", value=" + value +
                '}';
    }
}
