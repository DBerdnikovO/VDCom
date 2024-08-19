package org.example.task2;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author danilaberdnikov on ApplicationData.
 * @project VDCom
 */
public class ApplicationData {
    private LoanApplication loanApplication;
    private Loaners loaners;

    @XmlElement(name = "LoanApplication")
    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    @XmlElement(name = "Loaners")
    public Loaners getLoaners() {
        return loaners;
    }

    public void setLoaners(Loaners loaners) {
        this.loaners = loaners;
    }
}