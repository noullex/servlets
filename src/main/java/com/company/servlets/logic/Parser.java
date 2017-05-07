package com.company.servlets.logic;

import com.company.servlets.logic.content.Role;
import com.company.servlets.logic.content.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public void marshall(File file, List<User> users) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElementNS("", "users");
            doc.appendChild(rootElement);
            for (User user : users) {
                rootElement.appendChild(getUser(doc, user.getLogin(), user.getPassword(), user.getRole().name()));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult xmlFile = new StreamResult(file);
            transformer.transform(source, xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> unmarshall(File file) {
        List<User> users = new ArrayList<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("user");
            for (int i = 0; i < nodeList.getLength(); i++) {
                users.add(getUsers(nodeList.item(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    private User getUsers(Node node) {
        User user = new User();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            user.setLogin(getTagValue("login", element));
            user.setPassword(getTagValue("password", element));
            user.setRole(Role.valueOf(getTagValue("role", element)));
        }
        return user;
    }

    private Node getUser(Document doc, String login, String password, String role) {
        Element user = doc.createElement("user");
        user.appendChild(getUserElements(doc, "login", login));
        user.appendChild(getUserElements(doc, "password", password));
        user.appendChild(getUserElements(doc, "role", role));
        return user;
    }

    private Node getUserElements(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
