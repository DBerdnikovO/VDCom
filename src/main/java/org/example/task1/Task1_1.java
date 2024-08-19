package org.example;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;

/**
 * @author danilaberdnikov on ${NAME}.
 * @project Default (Template) Project
 */
public class Task1_1 {
    public static void main(String[] args) {
        try {
            // Путь к XSLT-файлу
            File xsltFile = new File("src/main/resources/task1/transform.xslt");

            // Путь к исходному XML-файлу
            File xmlFile = new File("src/main/resources/task1/input.xml");

            // Создание трансформатора
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Источник XML
            StreamSource xmlSource = new StreamSource(xmlFile);

            // Выходной результат (можно записать в файл или строку)
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            // Выполнение трансформации
            transformer.transform(xmlSource, result);

            // Вывод результата трансформации
            System.out.println("Result XML: \n" + writer);

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }}