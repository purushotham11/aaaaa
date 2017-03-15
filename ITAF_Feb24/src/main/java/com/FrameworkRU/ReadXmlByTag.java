package com.FrameworkRU;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * The Class ReadXmlByTag.
 * 
 * @author Praveen Gaddam
 */
public class ReadXmlByTag {

	/**
	 * Pick xpath data.
	 * 
	 * @param data
	 *            the data
	 * @param xpath
	 *            the xpath
	 * @return the string
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             the SAX exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XPathExpressionException
	 *             the x path expression exception
	 */
	@SuppressWarnings("unused")
	public static String pickXpathData(String data, String xpath)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		ByteArrayInputStream input = new ByteArrayInputStream(data.toString()
				.getBytes("UTF-8"));
		Document doc = builder.parse(input);
		XPath xPath = XPathFactory.newInstance().newXPath();
		String expression = xpath;
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc,
				XPathConstants.NODESET);
		String retVal = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Node firstChild = nNode.getFirstChild();
			retVal = firstChild.getNodeValue();
			break;
		}
		return retVal;
	}

	/**
	 * Read raw file.
	 * 
	 * @param path
	 *            the path
	 * @param encoding
	 *            the encoding
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String readRawFile(String path, Charset encoding)
			throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}
