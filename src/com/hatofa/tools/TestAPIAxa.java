package com.hatofa.tools;

import java.io.ByteArrayOutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class TestAPIAxa {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String pageUrl ="http://api.iot.conneq.tech/v1/device";
		String token = "18cf6598a272c0cb26d47e6ba432e2afa0740f17b065015a9d9f02ba5837b71d51e1c52e631de034018115f979bdca61526884ef6943120513f6487a854665c7d1c540991ec225b273e6acf74c158b3dbbb28b26c53ec725ad85cce39bc43090b71c848ced6447e9398f336836854003acaa54a18e42cbeb28d1b25906b856";

		HttpParams httpParams = new BasicHttpParams();
		int timeoutConnection = 10000;
		HttpConnectionParams.setConnectionTimeout(httpParams, timeoutConnection);
		int timeoutSocket = 10000;
		HttpConnectionParams.setSoTimeout(httpParams, timeoutSocket);

		HttpClient httpClient = new DefaultHttpClient(httpParams);

		HttpGet httpGet = new HttpGet(pageUrl);
		httpGet.setHeader("Authorization", "Bearer " + token);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");


		HttpResponse httpResponse = httpClient.execute(httpGet);
		StatusLine statusLine = httpResponse.getStatusLine();				
		if(statusLine.getStatusCode() == HttpStatus.SC_OK)
		{
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			httpResponse.getEntity().writeTo(outputStream);
			String responseString = outputStream.toString();
			System.out.println(responseString);
			
			//processding operations
		}		


	}

}
