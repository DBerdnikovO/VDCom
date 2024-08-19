package org.example.task2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author danilaberdnikov on SystemData.
 * @project VDCom
 */
@XmlRootElement(name = "SystemData")
@XmlAccessorType(XmlAccessType.FIELD)
public class SystemData {
    @XmlElement(name = "LoanProducts")
    private LoanProducts loanProducts;

    public LoanProducts getLoanProducts() {
        return loanProducts;
    }

    public void setLoanProducts(LoanProducts loanProducts) {
        this.loanProducts = loanProducts;
    }
}
