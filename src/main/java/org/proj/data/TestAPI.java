package org.proj.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class TestAPI {
	JSONObject item;
	StringBuilder sb;
	JSONArray jArr;
	// https://www.kopis.or.kr/openApi/restful/pblprfr?service=a3ccd6de629b409abe4d1edfec48dd96&cpage=1&rows=60&prfstate=02
	
	public TestAPI() {
		StringBuilder urlBuilder = new StringBuilder(
				"http://www.kopis.or.kr/openApi/restful/pblprfr"); /* URL */
		HttpURLConnection conn;
		
		try {
			urlBuilder.append("?" + URLEncoder.encode("service", "UTF-8") + "=a3ccd6de629b409abe4d1edfec48dd96"); /* 서비스키 */
			urlBuilder.append("&" + URLEncoder.encode("cpage", "UTF-8") + "="
					+ URLEncoder.encode("1", "UTF-8")); // 현재페이지 (stdate) ex) 1
			
			urlBuilder.append("&" + URLEncoder.encode("rows", "UTF-8") + "="
					+ URLEncoder.encode("300", "UTF-8")); // 페이지당 목록수 (stdate) ex) 10
			
			urlBuilder.append("&" + URLEncoder.encode("prfstate", "UTF-8") + "="
					+ URLEncoder.encode("02", "UTF-8")); // 공연상태코드 (stdate) ex) 02

			URL url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {

				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			} else {

				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

			}

			sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {

				sb.append(line);

			}
			rd.close();
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String xmlStr = sb.toString();
		jArr = XML.toJSONObject(xmlStr).getJSONObject("dbs").getJSONArray("db");
	}
	
	public void pageInit(int cpage) {
		StringBuilder urlBuilder = new StringBuilder(
				"http://www.kopis.or.kr/openApi/restful/pblprfr"); /* URL */
		HttpURLConnection conn;
		
		try {
			urlBuilder.append("?" + URLEncoder.encode("service", "UTF-8") + "=a3ccd6de629b409abe4d1edfec48dd96"); /* 서비스키 */
			urlBuilder.append("&" + URLEncoder.encode("cpage", "UTF-8") + "="
					+ URLEncoder.encode(cpage+"", "UTF-8")); // 현재페이지 (stdate) ex) 1
			
			urlBuilder.append("&" + URLEncoder.encode("rows", "UTF-8") + "="
					+ URLEncoder.encode("90", "UTF-8")); // 페이지당 목록수 (stdate) ex) 10
			
			urlBuilder.append("&" + URLEncoder.encode("prfstate", "UTF-8") + "="
					+ URLEncoder.encode("02", "UTF-8")); // 공연상태코드 (stdate) ex) 02

			URL url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {

				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			} else {

				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

			}

			sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {

				sb.append(line);

			}
			rd.close();
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String xmlStr = sb.toString();
		jArr = XML.toJSONObject(xmlStr).getJSONObject("dbs").getJSONArray("db");
	}
	
	
	public void testApi(){

		StringBuilder urlBuilder = new StringBuilder(
				"http://www.kopis.or.kr/openApi/restful/pblprfr"); /* URL */
		HttpURLConnection conn;
		
		try {
			urlBuilder.append("?" + URLEncoder.encode("service", "UTF-8") + "=a3ccd6de629b409abe4d1edfec48dd96"); /* 서비스키 */
			urlBuilder.append("&" + URLEncoder.encode("stdate", "UTF-8") + "="
					+ URLEncoder.encode("20220101", "UTF-8")); // 공연 시작일 (stdate) ex) 20220101
			
			urlBuilder.append("&" + URLEncoder.encode("eddate", "UTF-8") + "="
					+ URLEncoder.encode("202203010", "UTF-8")); // 공연 종료일 (eddate) ex) 20220331
			
			urlBuilder.append("&" + URLEncoder.encode("cpage", "UTF-8") + "="
					+ URLEncoder.encode("1", "UTF-8")); // 현재페이지 (stdate) ex) 1
			
			urlBuilder.append("&" + URLEncoder.encode("rows", "UTF-8") + "="
					+ URLEncoder.encode("10", "UTF-8")); // 페이지당 목록수 (stdate) ex) 10
			
			urlBuilder.append("&" + URLEncoder.encode("prfstate", "UTF-8") + "="
					+ URLEncoder.encode("02", "UTF-8")); // 공연상태코드 (stdate) ex) 02
			
			urlBuilder.append("&" + URLEncoder.encode("signgucode", "UTF-8") + "="
					+ URLEncoder.encode("11", "UTF-8")); // 지역(시도)코드 (stdate) ex) 11
			
			urlBuilder.append("&" + URLEncoder.encode("signgucodesub", "UTF-8") + "="
					+ URLEncoder.encode("1111", "UTF-8")); // 지역(구군)코드 (stdate) ex) 1111
			
			urlBuilder.append("&" + URLEncoder.encode("kidstate", "UTF-8") + "="
					+ URLEncoder.encode("", "UTF-8")); // 아동공연여부 (stdate) ex) Y
			

			URL url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
//			System.out.println("Response code: " + conn.getResponseCode());

			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {

				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			} else {

				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

			}

			sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {

				sb.append(line);

			}
			rd.close();
			conn.disconnect();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(sb.toString());
		
		
		
		String xmlStr = sb.toString();
		JSONObject json = XML.toJSONObject(xmlStr);
        JSONObject json2 = json.getJSONObject("dbs");
        jArr = json2.getJSONArray("db");
	}
	
	// http://www.kopis.or.kr/openApi/restful/pblprfr/PF132236?service={SeriveKey}
		public JSONObject detailInfo(String id){
			JSONObject json = null;
			
			StringBuilder urlBuilder = new StringBuilder(
					"http://www.kopis.or.kr/openApi/restful/pblprfr/"); /* URL */
			
			urlBuilder.append(id); // 공연 id 입력
			try {
				urlBuilder.append("?" + URLEncoder.encode("service", "UTF-8") + "=a3ccd6de629b409abe4d1edfec48dd96"); /* 서비스키 */

				URL url = new URL(urlBuilder.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");
//				System.out.println("Response code: " + conn.getResponseCode());

				BufferedReader rd;
				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {

					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				} else {

					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

				}

				sb = new StringBuilder();
				String line;
				while ((line = rd.readLine()) != null) {

					sb.append(line);

				}
				rd.close();
				conn.disconnect();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (ProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			String xmlStr = sb.toString();
			JSONObject tempjson = XML.toJSONObject(xmlStr);
			tempjson = tempjson.getJSONObject("dbs");
	        json = tempjson.getJSONObject("db");
	        
			return json;
		}
	
	
	public JSONObject getItem() {
		return item;
	}
	
	public JSONArray getJArr() {
		return jArr;
	}
}
