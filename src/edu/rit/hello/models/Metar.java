package edu.rit.hello.models;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Metar {
	
	protected static Logger logger = Logger.getLogger(Metar.class);
		
	public String temp = "No Data";
	public String windSpeed = "No Data";
	public String windDir = "No Data";
	public String elevation = "No Data";
	
	private Metar(String temp, String windSpeed, String windDir, String elevation) {
		this.temp = temp;
		this.windSpeed = windSpeed;
		this.windDir = windDir;
		this.elevation = elevation;
	}

	private Metar() {}

	public static Metar getMetarData(String loc) {
		URL url;
		logger.info("Location: " + loc);
		
		try {
			String data = "&stationString=" + URLEncoder.encode(loc, "UTF-8") + "&hoursBeforeNow=2";

			String urlString = "https://aviationweather.gov/adds/dataserver_current/httpparam?dataSource=metars&requestType=retrieve&format=xml";
				
			url = new URL(urlString + data);
			
			logger.info("URL: " + url);
			
			//Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("proxy.rit.edu", 1080));
				
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/xml");
			connection.setDoOutput(true);
			connection.setDoInput(true);

			OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
				
			wr.flush();
				
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(connection.getInputStream());
			
			logger.info("Document: ");
			logger.info(doc);
			
			NodeList nodes = doc.getElementsByTagName("METAR");
			Element elem = null;
			if (nodes.getLength() > 0) {
				if (nodes.item(0).getNodeType() == Node.ELEMENT_NODE) {
					elem = (Element) nodes.item(0);
				}
			}

			String temp_c = getValue("temp_c", elem);
			String wind_speed = getValue("wind_speed_kt", elem);
			String wind_dir = getValue("wind_dir_degrees", elem);
			String elevation = getValue("elevation_m", elem);
			
			return new Metar(temp_c, wind_speed, wind_dir, elevation);
			
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		} catch (MalformedURLException e) {
			logger.error(e);
		} catch (Exception e) {
			logger.error(e);
		}
		
		return new Metar();
	}

	private static String getValue(String tag, Element elem) {
		NodeList nodes = elem.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}
}
