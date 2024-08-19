package org.example.task2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * @author danilaberdnikov on ApplicantDetails.
 * @project VDCom
 */
public class ApplicantDetails {
    private String applicantName;
    private LocalDate birthDate;
    private String inn;

    @XmlElement(name = "ApplicantName")
    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    @XmlElement(name = "BirthDate")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @XmlElement(name = "INN")
    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}
