package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array

		encoded = new byte[str.getBytes().length+1];	
		
		encoded[0] = rpcid;
		
		int i = 1;
		for (byte b: str.getBytes()) {
			encoded[i++] = b;
		}
				
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		// TODO: unmarshall String contained in data into decoded

		decoded = new String(data,1,data.length-1);
		
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;

		// TODO: marshall RPC identifier in case of void type

		encoded = new byte[1];
		encoded[0] = rpcid;
		
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
		
		// void shall not return anything, so no action required
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array


		encoded = new byte[5];

		encoded[0] = rpcid;

		byte[] intToByteArray = ByteBuffer.allocate(4).putInt(x).array();
		for (int i = 0; i < intToByteArray.length; i++) {
			encoded[i + 1] = intToByteArray[i];
		}

//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data

		byte[] byteToIntArray = new byte[data.length];
		for (int i = 1; i < data.length; i++) {
			byteToIntArray[i - 1] = data[i];
		}
		
		decoded = ByteBuffer.wrap(byteToIntArray).getInt();
		
		return decoded;

	}
}
