package org.example.task2;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author danilaberdnikov on LoanApplication.
 * @project VDCom
 */
public class LoanApplication {
    private String productId;
    private double amount;
    private int term;

    @XmlElement(name = "ProductId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @XmlElement(name = "Amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @XmlElement(name = "Term")
    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
