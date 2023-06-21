package ru.netology;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List parseCSV(String[] columnMapping, String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Employee> strategy =
                    new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(reader)
                    .withMappingStrategy(strategy)
                    .build();
            return csv.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List parseXML(String fileName) throws ParserConfigurationException, IOException, SAXException {

        Employee employee;
        List<Employee> list = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));

        NodeList nodeList = doc.getElementsByTagName("employee");

        for (int i = 0; i < nodeList.getLength(); i++) {
            employee = new Employee();
            Node node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (Element) node;
                employee.id = Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent());
                employee.firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
                employee.lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
                employee.country = element.getElementsByTagName("country").item(0).getTextContent();
                employee.age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());
            }
            list.add(employee);
        }
        return list;
    }

    public static String listToJson(List list) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(list);
    }

    public static void writeString(String inputJson, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(inputJson);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        List<Employee> listCsv = parseCSV(new String[]{"id", "firstName", "lastName", "country", "age"}, "data.csv");
        System.out.println(listCsv);
        List<Employee> listXml = parseXML("data.xml");
        System.out.println(listXml);

        String json = listToJson(listCsv);
        System.out.println(json);
        String xml = listToJson(listXml);
        System.out.println(xml);

        writeString(json, "new_data_csv.json");
        writeString(xml,"new_data_xml.json");

    }
}