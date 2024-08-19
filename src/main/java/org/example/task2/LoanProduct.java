package org.example.task2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author danilaberdnikov on LoanProduct.
 * @project VDCom
 */
public class LoanProduct {
    private String id;
    private double minAmount;
    private double maxAmount;
    private int minTerm;
    private int maxTerm;

    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "MinAmount")
    public double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(double minAmount) {
        this.minAmount = minAmount;
    }

    @XmlElement(name = "MaxAmount")
    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @XmlElement(name = "MinTerm")
    public int getMinTerm() {
        return minTerm;
    }

    public void setMinTerm(int minTerm) {
        this.minTerm = minTerm;
    }

    @XmlElement(name = "MaxTerm")
    public int getMaxTerm() {
        return maxTerm;
    }

    public void setMaxTerm(int maxTerm) {
        this.maxTerm = maxTerm;
    }
}
