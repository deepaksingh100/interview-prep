package me.deepak.interview.string.regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
 * Log format
 * 203.115.106.4 - - [04/Nov/2019:10:38:02 +0530] "GET /javascripts/pagination.min.js HTTP/1.0" 304 0 "https://www.google.com" "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36" "0.002" "127.0.0.1:8080" "0.002"
*/
public class ExtractClientIPFromNginxLogs {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(new File("path-to-nginx-log-file")));

		Set<String> set = new HashSet<>();
		String readLine = "";
		while ((readLine = reader.readLine()) != null) {
			String clientIp = readLine.split(" ")[0];
			set.add(clientIp);
		}
		System.out.println(set);
		reader.close();
	}

}
