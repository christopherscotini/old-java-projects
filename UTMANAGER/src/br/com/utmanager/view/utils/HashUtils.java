package br.com.utmanager.view.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public final class HashUtils {

	private HashUtils() {
		super();
	}

	public static String md5(String text) {
		return Hashing.md5().hashString(text, Charsets.UTF_8).toString();
	}
}
