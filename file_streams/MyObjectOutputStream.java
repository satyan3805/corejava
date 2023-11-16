package com.sat;

//Importing input output classes
import java.io.*;
//Importing utility classes
import java.util.*;

public class MyObjectOutputStream extends ObjectOutputStream {

	MyObjectOutputStream() throws IOException {
		super();
	}
	MyObjectOutputStream(OutputStream o) throws IOException {
		super(o);
	}
	public void writeStreamHeader() throws IOException {
		return;
	}
}