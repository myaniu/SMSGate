package com.zx.sms.codec.cmpp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import org.junit.Assert;
import org.junit.Test;
import org.marre.sms.DcsGroup;

import com.zx.sms.codec.AbstractTestMessageCodec;
import com.zx.sms.codec.cmpp.msg.CmppSubmitRequestMessage;

import static com.zx.sms.common.util.NettyByteBufUtil.*;
public class TestMsgDataSubmitRequestDecoder2 extends AbstractTestMessageCodec<CmppSubmitRequestMessage> {
	@Override
	protected int getVersion() {
		return 0x20;
	}
	@Test
	public void testDecodedcsErr() {
		byte[] expected = prepareMsgData();
		//使fmt字段值
		expected[58] = (byte)0xA8;
		
		byte[] actuals = new byte[expected.length];
		ByteBuf buf = Unpooled.wrappedBuffer(expected);
		int index = 0;
		ch.writeInbound(buf);
		CmppSubmitRequestMessage result = null;
		while (null != (result = (CmppSubmitRequestMessage) ch.readInbound())) {
			System.out.println(result);
			ByteBuf bytebuf = Unpooled.copiedBuffer(encode(result));
			int lenght = bytebuf.readableBytes();
			System.arraycopy(toArray(bytebuf), 0, actuals, index,lenght );
			index = lenght;
		}
		Assert.assertArrayEquals(expected, actuals);
	}
	//@Test
	public void testDecode() {
		byte[] expected = prepareMsgData();
		byte[] actuals = new byte[expected.length];
		ByteBuf buf = Unpooled.wrappedBuffer(expected);
		int index = 0;
		ch.writeInbound(buf);
		CmppSubmitRequestMessage result = null;
		while (null != (result = (CmppSubmitRequestMessage) ch.readInbound())) {
			System.out.println(result);
			ByteBuf bytebuf = Unpooled.copiedBuffer(encode(result));
			int lenght = bytebuf.readableBytes();
			System.arraycopy(toArray(bytebuf), 0, actuals, index,lenght );
			index = lenght;
		}
		Assert.assertArrayEquals(expected, actuals);
	}

	// 下面数据截取自现网10085的报文。cmppSubmit2.0协议
	private byte[] prepareMsgData() {
		return new byte[] {(byte)0x00,(byte)0x00,(byte)0x00,(byte)0xcf,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x04,(byte)0x05,(byte)0x76,(byte)0xbe,(byte)0xfb,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x01,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x08,(byte)0x34,(byte)0x30,(byte)0x30,(byte)0x34,(byte)0x33
				,(byte)0x37,(byte)0x30,(byte)0x31,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x31,(byte)0x30,(byte)0x30,(byte)0x38,(byte)0x35
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x01,(byte)0x31,(byte)0x33,(byte)0x37,(byte)0x32,(byte)0x38,(byte)0x38,(byte)0x30,(byte)0x31,(byte)0x37,(byte)0x35,(byte)0x38,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x30,(byte)0x60,(byte)0xa8,(byte)0x59,(byte)0x7d,(byte)0xff,(byte)0x0c,(byte)0x60,(byte)0xa8,(byte)0x76
				,(byte)0x84,(byte)0x5b,(byte)0x9e,(byte)0x54,(byte)0x0d,(byte)0x52,(byte)0x36,(byte)0x8b,(byte)0xa4,(byte)0x8b,(byte)0xc1,(byte)0x76,(byte)0x7b,(byte)0x96,(byte)0x46,(byte)0x77
				,(byte)0xed,(byte)0x4f,(byte)0xe1,(byte)0x96,(byte)0x8f,(byte)0x67,(byte)0x3a,(byte)0x78,(byte)0x01,(byte)0x4e,(byte)0x3a,(byte)0x00,(byte)0x36,(byte)0x00,(byte)0x30,(byte)0x00
				,(byte)0x31,(byte)0x00,(byte)0x32,(byte)0x00,(byte)0x35,(byte)0x00,(byte)0x30,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0xcf,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x04,(byte)0x05,(byte)0x76,(byte)0xbe,(byte)0xfc,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x01,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x08,(byte)0x34,(byte)0x30,(byte)0x30,(byte)0x34,(byte)0x33,(byte)0x37
				,(byte)0x30,(byte)0x31,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x31,(byte)0x30,(byte)0x30,(byte)0x38,(byte)0x35,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x01
				,(byte)0x31,(byte)0x35,(byte)0x38,(byte)0x38,(byte)0x38,(byte)0x31,(byte)0x36,(byte)0x35,(byte)0x37,(byte)0x38,(byte)0x39,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
				,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x30,(byte)0x60,(byte)0xa8,(byte)0x59,(byte)0x7d,(byte)0xff,(byte)0x0c,(byte)0x60,(byte)0xa8,(byte)0x76,(byte)0x84
				,(byte)0x5b,(byte)0x9e,(byte)0x54,(byte)0x0d,(byte)0x52,(byte)0x36,(byte)0x8b,(byte)0xa4,(byte)0x8b,(byte)0xc1,(byte)0x76,(byte)0x7b,(byte)0x96,(byte)0x46,(byte)0x77,(byte)0xed
				,(byte)0x4f,(byte)0xe1,(byte)0x96,(byte)0x8f,(byte)0x67,(byte)0x3a,(byte)0x78,(byte)0x01,(byte)0x4e,(byte)0x3a,(byte)0x00,(byte)0x31,(byte)0x00,(byte)0x33,(byte)0x00,(byte)0x37
				,(byte)0x00,(byte)0x32,(byte)0x00,(byte)0x32,(byte)0x00,(byte)0x34,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00};
	}

}
