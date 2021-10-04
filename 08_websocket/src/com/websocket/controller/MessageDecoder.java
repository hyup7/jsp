package com.websocket.controller;

import javax.websocket.DecodeException;
import javax.websocket.Decoder.Text;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.websocket.model.vo.Message;

public class MessageDecoder implements Text<Message> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message decode(String arg0) throws DecodeException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(arg0, Message.class);
	}

	@Override
	public boolean willDecode(String arg0) {
		// TODO Auto-generated method stub
		return true;//true해야지 인코딩처리가 됨
	}

	
}
