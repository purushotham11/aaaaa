package com.FrameworkRU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xml.sax.SAXException;

/**
 * The Class RestCallMethods.
 * 
 * @author Praveen Gaddam and Kiran Kumar Cherukuri
 */
@SuppressWarnings("deprecation")
public class RestCallMethods {

	static ReadXmlByTag readXmlByTag = new ReadXmlByTag();
	public static List<String> xmlposteddata = new ArrayList<String>();

	static {
		uniqueToken();
	}

	@SuppressWarnings("static-access")
	public static void postRest(String url, String userName, String password,
			String fileName, String finalFileName)
			throws NoSuchAlgorithmException, KeyManagementException,
			XPathExpressionException, ParserConfigurationException,
			SAXException, InterruptedException {
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			makeupHttpsContent(httpClient);
			HttpPost postRequest = new HttpPost(url);
			postRequest.addHeader("User", userName);
			postRequest.addHeader("Password", password);
			postRequest.addHeader("fileName", finalFileName);
			String filePath = "src/test/resources/ExcelTestDataFiles/HILTI_TOOLS/SAPXMLS/"
					+ fileName;
			String readFile = readRawFile(filePath, Charset.defaultCharset());
			Map<String, String> map = new HashMap<String, String>();
			map.put("customerNo",
					PropertyReader.getRuntimeTestData("Common_CustomerNumber"));
			map.put("materialNumber", ReadXMlData.productmaster_materialnumber);
			map.put("equipmentnumber1", "EN"+ApplicationUtils.getUniqueString(5));
			map.put("equipmentnumber2", "EN"+ApplicationUtils.getUniqueString(5));
			map.put("equipmentnumber3", "EN"+ApplicationUtils.getUniqueString(5));
			map.put("equipmentnumber4", "EN"+ApplicationUtils.getUniqueString(5));
			map.put("equipmentnumber5", "EN"+ApplicationUtils.getUniqueString(5));
			map.put("equipmentnumber6", "EN"+ApplicationUtils.getUniqueString(5));
			map.put("equipmentnumber7", "EN"+ApplicationUtils.getUniqueString(5));
			map.put("equipmentnumber8", "EN"+ApplicationUtils.getUniqueString(5));
			map.put("equipmentnumber9", "EN"+ApplicationUtils.getUniqueString(5));
			map.put("equipmentnumber10", "EN"+ApplicationUtils.getUniqueString(5));
			map.put("equipmentnumber11", "EN"+ApplicationUtils.getUniqueString(5));
			map.put("scancode1", "SC"+ApplicationUtils.getUniqueString(5));
			map.put("scancode2", "SC"+ApplicationUtils.getUniqueString(5));
			map.put("scancode3", "SC"+ApplicationUtils.getUniqueString(5));
			map.put("scancode4", "SC"+ApplicationUtils.getUniqueString(5));
			map.put("scancode5", "SC"+ApplicationUtils.getUniqueString(5));
			map.put("scancode6", "SC"+ApplicationUtils.getUniqueString(5));
			map.put("scancode7", "SC"+ApplicationUtils.getUniqueString(5));
			map.put("scancode8", "SC"+ApplicationUtils.getUniqueString(5));
			map.put("scancode9", "SC"+ApplicationUtils.getUniqueString(5));
			map.put("scancode10", "SC"+ApplicationUtils.getUniqueString(5));
			map.put("scancode11", "SC"+ApplicationUtils.getUniqueString(5));
			TemplateHandleUtil instance = TemplateHandleUtil.getInstance();
			readFile = instance.handleTemplate(readFile, map);
			System.out.println("Updated file------------------------"
					+ readFile);
			xmlposteddata.add(readFile);
			StringEntity input = new StringEntity(readFile);
			postRequest.setEntity(input);
			HttpResponse response = httpClient.execute(postRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));
			String output;
			String status = null;
			while ((output = br.readLine()) != null) {
				status = readXmlByTag.pickXpathData(output, "/response/status");
			}
			if (status.equals("SUCCESS")) {
				System.out.println("============" + filePath
						+ " Upload - Success ================");
			} else {
				System.out.println("============" + filePath
						+ " File Upload - Unsuccess ================");
			}
			FileUtils.writeInputFileToOut(fileName, readFile);
			httpClient.getConnectionManager().shutdown();
			System.out
					.println("******Waiting for New Asset creation payload Success Email Confirmation******");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Unique token.
	 * 
	 * @return the string
	 */
	private static String uniqueToken() {
		UUID randomUUID = UUID.randomUUID();
		String[] tokens = randomUUID.toString().split("-");
		String lastToken = tokens[tokens.length - 1];
		return lastToken;
	}

	/**
	 * Makeup https content.
	 * 
	 * @param httpClient
	 *            the http client
	 * @throws NoSuchAlgorithmException
	 *             the no such algorithm exception
	 * @throws KeyManagementException
	 *             the key management exception
	 */
	private static void makeupHttpsContent(DefaultHttpClient httpClient)
			throws NoSuchAlgorithmException, KeyManagementException {
		X509TrustManager tm = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] xcs, String string)
					throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] xcs, String string)
					throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};

		SSLContext ctx = SSLContext.getInstance("TLS");
		ctx.init(null, new TrustManager[] { tm }, null);
		SSLSocketFactory ssf = new SSLSocketFactory(ctx,
				SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		ClientConnectionManager ccm = httpClient.getConnectionManager();
		SchemeRegistry sr = ccm.getSchemeRegistry();
		sr.register(new Scheme("https", ssf, 443));
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
	static String readRawFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	/**
	 * Gets the unique string.
	 * 
	 * @param len
	 *            the len
	 * @return the unique string
	 */
	public static String getUniqueString(int len) {
		return RandomStringUtils.randomAlphabetic(len);
	}

	/**
	 * Gets the random numeric.
	 * 
	 * @return the random numeric
	 */
	public static int getRandomNumeric() {
		Random r = new Random(System.currentTimeMillis());
		return 10000 + r.nextInt(20000);
	}

}