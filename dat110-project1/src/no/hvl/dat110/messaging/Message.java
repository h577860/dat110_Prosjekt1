package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if (payload.length < MessageConfig.SEGMENTSIZE -1) {// minus one as you need one byte free to store length
		this.payload = payload; // TODO: check for length within boundary
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = new byte[MessageConfig.SEGMENTSIZE];
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		encoded[0]=(byte) payload.length;
		for (int i=0; i<payload.length; i++ ) {
		encoded[i+1]=payload[i];
		}
		//if (true)
		   //throw new UnsupportedOperationException(TODO.method());

		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		
		int length = received[0];
		payload = new byte[length];
		
		for(int i = 0; i < length; i++) {
			payload[i] = received[i+1];
		}
		
		// AE this is not working yet
//		Message receivedmessage = new Message(received);
//		payload=receivedmessage.getData();
		
		// throw new UnsupportedOperationException(TODO.method());
		
	}
}
