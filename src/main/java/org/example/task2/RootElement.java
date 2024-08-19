package org.example.task2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author danilaberdnikov on RootElement.
 * @project VDCom
 */
@XmlRootElement(name = "RootElement")
public class RootElement {
    private SystemData systemData;
    private ApplicationData applicationData;

    @XmlElement(name = "SystemData")
    public SystemData getSystemData() {
        return systemData;
    }

    public void setSystemData(SystemData systemData) {
        this.systemData = systemData;
    }

    @XmlElement(name = "ApplicationData")
    public ApplicationData getApplicationData() {
        return applicationData;
    }

    public void setApplicationData(ApplicationData applicationData) {
        this.applicationData = applicationData;
    }
}