package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		int temp;
		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		
		temp=0;
		byte[] readInt = RPCUtils.marshallInteger(RPCID, temp);
		byte[] call = rpcclient.call(readInt);
		temp = RPCUtils.unmarshallInteger(call);
		
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}
		
		return temp;
	}
	
}
