package wolframapha.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 

public class AlphaApi {
	
	public String test(String content) {
		try {
			return AlphaApi.call_me(content);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	   
	private static String call_me(String content) throws Exception {
		String url = "https://api.wolframalpha.com/v1/result?i="+content+"%3F&appid=5G8L5U-UWP3TEQTY5";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		int responseCode = con.getResponseCode();
		
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader in = new BufferedReader(
		    new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		
		in.close();
		System.out.println(response.toString());
		
		return response.toString();
	}
}
