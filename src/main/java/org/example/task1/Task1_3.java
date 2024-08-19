package org.example.task1;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;

/**
 * @author danilaberdnikov on Task1_3.
 * @project VDCom
 */
public class Task1_3 {
    public static void main(String[] args) {
        try {
            File xsltFile = new File("src/main/resources/task1/task13/transform.xslt");

            File xmlFile = new File("src/main/resources/task1/task13/input.xml");

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            StreamSource xmlSource = new StreamSource(xmlFile);

            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            transformer.transform(xmlSource, result);

            System.out.println("Result XML: \n" + writer);

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
