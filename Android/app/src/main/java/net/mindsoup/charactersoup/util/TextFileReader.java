package net.mindsoup.charactersoup.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFileReader {

	public static String readText(Context context, String fileName) {
		String text = "";
		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader (new InputStreamReader(context.getAssets().open(fileName)));
			String thisLine = "";
			while((thisLine = br.readLine()) != null)
				sb.append(thisLine);
			
			br.close();
			text = sb.toString();
			
		} catch (IOException e) {
			text = e.getMessage();
			e.printStackTrace();
		}
		
		return text;
	}
}
