package org.example.task2;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author danilaberdnikov on Loaners.
 * @project VDCom
 */
public class Loaners {
    private List<ApplicantDetails> applicantDetails;

    @XmlElement(name = "ApplicantDetails")
    public List<ApplicantDetails> getApplicantDetails() {
        return applicantDetails;
    }

    public void setApplicantDetails(List<ApplicantDetails> applicantDetails) {
        this.applicantDetails = applicantDetails;
    }
}
