package org.example.task2;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author danilaberdnikov on LoanProducts.
 * @project VDCom
 */
public class LoanProducts {
    private List<LoanProduct> loanProducts;

    @XmlElement(name = "LoanProduct")
    public List<LoanProduct> getLoanProducts() {
        return loanProducts;
    }

    public void setLoanProducts(List<LoanProduct> loanProducts) {
        this.loanProducts = loanProducts;
    }
}
