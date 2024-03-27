package com.example.smbms.pojo;

public class BillWithProvider extends Bill {
    private String providerName; // 供应商名称
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
